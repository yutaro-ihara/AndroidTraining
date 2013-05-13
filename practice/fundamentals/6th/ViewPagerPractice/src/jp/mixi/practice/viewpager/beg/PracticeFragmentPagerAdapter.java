package jp.mixi.practice.viewpager.beg;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PracticeFragmentPagerAdapter extends FragmentPagerAdapter {
	
	private static final int PAGE_COUNT = 5;

	public PracticeFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		return PracticeFragment.newInstance(arg0);
	}

	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

}
