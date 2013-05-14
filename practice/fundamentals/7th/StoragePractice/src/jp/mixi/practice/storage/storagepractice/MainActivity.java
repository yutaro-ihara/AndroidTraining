package jp.mixi.practice.storage.storagepractice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.internalFileSave).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				TextView text = (TextView) findViewById(R.id.text);
				saveTextToInternalStorage(text.getText().toString());
			}
		});
		
		findViewById(R.id.externalFileSave).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView text = (TextView) findViewById(R.id.file);
				saveImageToExternalStorage(text.getText().toString());
			}
		});
	}
	
	private void saveTextToInternalStorage(String textBody) {
		try {
			FileOutputStream stream;
			stream = openFileOutput("hello_file", MODE_PRIVATE);
			stream.write(textBody.getBytes());
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void saveImageToExternalStorage(String filename) {
		try {
			File externalFile = new File(getExternalFilesDir(null), filename);
			Log.v("path", externalFile.getPath());
			InputStream in = getResources().openRawResource(R.drawable.ic_launcher);
			OutputStream out;
			out = new FileOutputStream(externalFile);
			byte[] bytes = new byte[in.available()];
			in.read(bytes);
			out.write(bytes);
			in.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
