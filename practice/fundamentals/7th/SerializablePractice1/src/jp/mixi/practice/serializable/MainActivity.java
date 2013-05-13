package jp.mixi.practice.serializable;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.google.gson.GsonBuilder;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 1. 取得したデータをUserクラスにマッピングしてください。
		// 2. UserクラスにParcelableインターフェイスを実装してください。
		// 各項目を画面に表示してください
		NetworkClient client = new NetworkClient();
		String json = client.getUser(123);
		Log.v("hoge", json);
		User user = parseJSON(json);
		assignView(user);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private User parseJSON(String jsonString) {
		User user = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create().fromJson(jsonString, User.class);

		return user;
	}

	private void assignView(User user) {
		((TextView) findViewById(R.id.userId)).setText(String.valueOf(user
				.getId()));
		((TextView) findViewById(R.id.userAge)).setText(String.valueOf(user
				.getAge()));
		((TextView) findViewById(R.id.userKeyword)).setText(user.getKeyword());
		((TextView) findViewById(R.id.userName)).setText(user.getName());
		((TextView) findViewById(R.id.userStatusText)).setText(user.getStatus()
				.getText());
	}

}
