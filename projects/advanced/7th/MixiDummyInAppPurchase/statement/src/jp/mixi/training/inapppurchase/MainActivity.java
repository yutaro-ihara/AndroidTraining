package jp.mixi.training.inapppurchase;

import jp.mixi.training.inapppurchase.helper.DummySku;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.vending.billing.IInAppBillingService;

public class MainActivity extends FragmentActivity {
	private static final String TAG = MainActivity.class.getSimpleName();

	IInAppBillingService mService;

	ServiceConnection mServiceConnection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			mService = null;
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mService = IInAppBillingService.Stub.asInterface(service);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bindService(new Intent(
				"com.android.vending.billing.InAppBillingService.BIND"),
				mServiceConnection, Context.BIND_AUTO_CREATE);
	}

	private void disableActionViews() {
		findViewById(R.id.action_start_accepted_purchase).setEnabled(false);
		findViewById(R.id.action_start_canceled_purchase).setEnabled(false);
	}

	private void enableActionViews() {
		findViewById(R.id.action_start_accepted_purchase).setEnabled(true);
		findViewById(R.id.action_start_canceled_purchase).setEnabled(true);
	}

	private void showResult(final boolean resultOk, final String text) {
		final TextView resultView = (TextView) findViewById(R.id.print_purchase_result);
		if (resultView != null) {
			resultView.setBackgroundColor(getResources().getColor(
					resultOk ? R.color.result_ok_bg : R.color.result_ko_bg));
			resultView.setText(text != null ? text : "");
		} else {
			Log.w(TAG, "Can't find result view ; nothing done");
		}
		enableActionViews();
	}

	private void consume(String data) {
		try {
			String token = "inapp:" + getPackageName()
					+ ":android.test.purchased";
			int response = mService.consumePurchase(3, getPackageName(), token);
			Log.v(TAG, String.valueOf(response));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		if (mServiceConnection != null) {
			unbindService(mServiceConnection);
		}
	}

	private void startPurchase(final DummySku skuToPurchase) {
		disableActionViews();

		try {
			Bundle buyIntent = mService.getBuyIntent(3, getPackageName(),
					skuToPurchase.getId(), "inapp", "");

			if (buyIntent.getInt("RESPONSE_CODE") != 0) {
				int resultCode = buyIntent.getInt("RESPONSE_CODE");
				showResult(false, String.valueOf(resultCode));

				if (resultCode == 7) {
					consume(buyIntent.getString("INAPP_PURCHASE_DATA"));
				}
				return;
			}

			PendingIntent pendingIntent = buyIntent.getParcelable("BUY_INTENT");

			startIntentSenderForResult(pendingIntent.getIntentSender(), 1001,
					new Intent(), Integer.valueOf(0), Integer.valueOf(0),
					Integer.valueOf(0));
		} catch (RemoteException e) {
			showResult(false, e.getLocalizedMessage());
		} catch (SendIntentException e) {
			showResult(false, e.getLocalizedMessage());
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_CANCELED) {
			return;
		}

		if (requestCode == 1001) {
			int responseCode = data.getIntExtra("RESPONSE_CODE", 0);
			String purchaseData = data.getStringExtra("INAPP_PURCHASE_DATA");
			String dataSignature = data.getStringExtra("INAPP_DATA_SIGNATURE");

			if (resultCode == RESULT_OK && responseCode == 0) {
				try {
					JSONObject jsonObj = new JSONObject(purchaseData);
					String sku = jsonObj.getString("productId");
					showResult(true, sku);
					return;
				} catch (JSONException e) {
					showResult(false, e.getLocalizedMessage());
					return;
				} catch (Exception e) {
					showResult(false, e.getLocalizedMessage());
					return;
				}
			}
		}

		showResult(false, "error");
	}

	public void onStartAcceptedPurchaseClick(final View view) {
		startPurchase(DummySku.PURCHASED);
	}

	public void onStartCanceledPurchaseClick(final View view) {
		startPurchase(DummySku.CANCELED);
	}
}
