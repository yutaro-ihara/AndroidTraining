package jp.mixi.practice.intent.beg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class NewActivity2 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent receiveIntent = getIntent();
		String stringExtra = receiveIntent.getStringExtra("toast_message");
		
		Toast.makeText(getApplicationContext(), stringExtra, Toast.LENGTH_SHORT).show();
	}
}
