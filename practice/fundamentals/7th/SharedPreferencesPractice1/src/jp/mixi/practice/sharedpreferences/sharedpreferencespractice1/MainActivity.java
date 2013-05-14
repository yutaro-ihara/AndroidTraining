package jp.mixi.practice.sharedpreferences.sharedpreferencespractice1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private SharedPreferences mPrivatePreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPrivatePreferences = getSharedPreferences("practice", MODE_PRIVATE);
        // privatePreferencesに値が存在すればその値を表示をしてください。
        String text = mPrivatePreferences.getString("target", "No Data");
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        // privatePreferencesにString,int,boolean,long,floatで何らかの値を保存してください。
        Editor editor = mPrivatePreferences.edit();
        editor.putString("target", "hi");
        editor.putBoolean("bool", true);
        editor.putInt("integer", 1);
        editor.putLong("long", 3);
        editor.putFloat("float", (float) 0.1);
        editor.commit();

        Button clearButton = (Button) findViewById(R.id.clear);
        clearButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 内容をクリアする処理を書いてください。
            	mPrivatePreferences.edit().clear().commit();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
