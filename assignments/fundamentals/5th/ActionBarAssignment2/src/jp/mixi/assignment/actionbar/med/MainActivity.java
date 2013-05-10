
package jp.mixi.assignment.actionbar.med;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

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
        bar.addTab(bar.newTab().setText(R.string.tab_text1).setTabListener(this));
        bar.addTab(bar.newTab().setText(R.string.tab_text2).setTabListener(this));
        bar.addTab(bar.newTab().setText(R.string.tab_text3).setTabListener(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getSupportMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch(item.getItemId()) {
		case R.id.action_new_activity:
			onNewActivityItemHandler();
			break;
		case R.id.action_shutdown_app:
			onShutdownAppItemHandler();
			break;
		}
		
		return super.onMenuItemSelected(featureId, item);
	}
	
	private void onNewActivityItemHandler() {
		Intent intent = new Intent(getApplicationContext(), NewActivity.class);
		startActivity(intent);
	}
	
	private void onShutdownAppItemHandler() {
		finish();
	}

}
