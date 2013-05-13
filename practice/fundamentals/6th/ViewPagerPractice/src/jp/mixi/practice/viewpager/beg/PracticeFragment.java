package jp.mixi.practice.viewpager.beg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PracticeFragment extends Fragment {
	public static PracticeFragment newInstance(int position) {
		PracticeFragment instance = new PracticeFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("positon", position);
		instance.setArguments(bundle);

		return instance;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Bundle bundle = getArguments();
		int position = 0;
		if (bundle != null) {
			position = bundle.getInt("positon");
		}
		
		View view = inflater.inflate(R.layout.fragment_main, container, false);
		TextView textView = (TextView) view.findViewById(R.id.TextView1);
		textView.setText(String.valueOf(position));
		
		return view;
	}
}
