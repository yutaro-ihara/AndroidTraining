package jp.mixi.practice.actionbar.beg;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;

public class MainActivity extends SherlockActivity implements TabListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ActionBar bar = getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		bar.addTab(bar.newTab().setText("tab1").setTabListener(this));
		bar.addTab(bar.newTab().setText("tab2").setTabListener(this));
		bar.addTab(bar.newTab().setText("tab3").setTabListener(this));
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Toast.makeText(getApplicationContext(), tab.getText(),
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		Toast.makeText(getApplicationContext(), tab.getText(),
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
