package jp.mixi.practice.test.target.test;

import jp.mixi.practice.test.target.R;
import jp.mixi.practice.test.target.TestTarget3;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class TestPractice3 extends
		ActivityInstrumentationTestCase2<TestTarget3> {

	public TestPractice3() {
		this(TestTarget3.class);
	}

	public TestPractice3(Class<TestTarget3> activityClass) {
		super(activityClass);
	}

	public void testTextChangeScenario() throws Exception {
		Activity activity = getActivity();

		TextView title = (TextView) activity.findViewById(R.id.TitleEditor);
		TextView content = (TextView) activity.findViewById(R.id.ContentEditor);
		TextView titleCounter = (TextView) activity
				.findViewById(R.id.TitleCounter);
		TextView contentCounter = (TextView) activity
				.findViewById(R.id.ContentCounter);

		assertEquals("", title.getText().toString());
		assertEquals("", content.getText().toString());
		assertEquals("", titleCounter.getText().toString());
		assertEquals("", contentCounter.getText().toString());

		activity.runOnUiThread(new Runnable() {

			@Override
			public void run() {
				Activity activity = getActivity();
				TextView title = (TextView) activity.findViewById(R.id.TitleEditor);
				TextView content = (TextView) activity.findViewById(R.id.ContentEditor);
				TextView titleCounter = (TextView) activity
						.findViewById(R.id.TitleCounter);
				TextView contentCounter = (TextView) activity
						.findViewById(R.id.ContentCounter);
				title.setText("hoge");
				content.setText("hogehoge");
				
				assertEquals("4 / 10", titleCounter.getText().toString());
				assertEquals("8 / 10000", contentCounter.getText().toString());
				
				activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
				assertEquals("", titleCounter.getText().toString());
			}
		});
		
	}
}
