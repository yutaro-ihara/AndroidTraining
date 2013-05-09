package jp.mixi.assignment.res.string.beg;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// TODO 1 個のものと、複数個のものの両方を並べて表示するため、両方用の TextView を取り出し、リソースへアクセスして表示する
		TextView one = (TextView) findViewById(R.id.PluralsTextForOne);
		TextView other = (TextView) findViewById(R.id.PluralsTextForOther);

		one.setText(getResources().getQuantityString(R.plurals.texts, 1));
		other.setText(getResources().getQuantityString(R.plurals.texts, 5, 5));
	}
}