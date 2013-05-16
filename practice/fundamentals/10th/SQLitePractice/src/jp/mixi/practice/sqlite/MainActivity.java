package jp.mixi.practice.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.Insert).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				insert();
			}
		});
		findViewById(R.id.Delete).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				delete();
			}
		});
		findViewById(R.id.Update).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				update();
			}
		});
		findViewById(R.id.Query).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				query();
			}
		});

	}

	private void insert() {
		ContentValues values = new ContentValues();

		values.clear();
		values.put(Book.COLUMN_NAME_BOOK_TITLE, "title a");
		values.put(Book.COLUMN_NAME_BOOK_PRICE, "price 1");
		values.put(Book.COLUMN_NAME_BOOK_PUBLISHER, "publisher a");

		getContentResolver().insert(Book.CONTENT_URI, values);
		Log.d(TAG, "inserted ");
	}

	private void delete() {
		int delete = getContentResolver().delete(Book.CONTENT_URI, null, null);
		Log.d(TAG, "deleted " + delete);
	}

	private void update() {
		ContentValues values = new ContentValues();
		values.clear();
		values.put(Book.COLUMN_NAME_BOOK_TITLE, "title b");
		int update = getContentResolver().update(Book.CONTENT_URI, values,
				null, null);
		Log.d(TAG, "updated " + update);
	}

	private void query() {
		Cursor cursor = getContentResolver().query(Book.CONTENT_URI, null,
				null, null, null);
		while (cursor.moveToNext()) {
			Log.d(TAG, cursor.getString(cursor
					.getColumnIndexOrThrow(Book.COLUMN_NAME_BOOK_TITLE)));
		}
		cursor.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
