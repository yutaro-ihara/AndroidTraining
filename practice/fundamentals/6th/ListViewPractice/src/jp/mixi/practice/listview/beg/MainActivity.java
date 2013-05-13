package jp.mixi.practice.listview.beg;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private MainActivity mActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mActivity = this;

		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 60; i++) {
			list.add("hoge" + i);
		}

		ListView listView = (ListView) findViewById(R.id.ListView);
		CustomListItemAdapter adapter = new CustomListItemAdapter(mActivity,
				list);

		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String str = (String) arg0.getItemAtPosition(arg2);
				Toast.makeText(mActivity, str, Toast.LENGTH_SHORT).show();
			}

		});

		View button = findViewById(R.id.Button);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ListView listView = (ListView) findViewById(R.id.ListView);
				listView.smoothScrollToPosition(0);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
