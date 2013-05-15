package jp.mixi.practice.network.networkpractice1;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements
		LoaderCallbacks<String> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		View buttonGet = findViewById(R.id.buttonGet);

		buttonGet.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// http getの処理を書く
				sendRequestByClickButton("get");
			}
		});
		View buttonPost = findViewById(R.id.buttonPost);
		buttonPost.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// http postの処理を書く
				sendRequestByClickButton("post");
			}
		});

	}

	private void sendRequestByClickButton(String method) {
		Log.v(MainActivity.class.getSimpleName(), "start");
		TextView accessUrlText = (TextView) findViewById(R.id.accessUrl);
		TextView paramText = (TextView) findViewById(R.id.httpBody);
		LoaderManager manager = getSupportLoaderManager();
		Bundle args = new Bundle();
		args.putString("url", accessUrlText.getText().toString());
		args.putString("method", method);
		args.putString("param", paramText.getText().toString());
		manager.initLoader(0, args, MainActivity.this);
		Log.v(MainActivity.class.getSimpleName(), "finish");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	public Loader<String> onCreateLoader(int id, Bundle args) {
		switch (id) {
		case 0:
			return new NetworkAsyncTaskLoader(this, args.getString("method"),
					args.getString("url"), args.getString("param"));
		default:
			return null;
		}
	}

	@Override
	public void onLoadFinished(Loader<String> arg0, String arg1) {
		TextView textView = (TextView) findViewById(R.id.responce);

		textView.setText(arg1);
	}

	@Override
	public void onLoaderReset(Loader<String> arg0) {
		// TODO Auto-generated method stub

	}

}
