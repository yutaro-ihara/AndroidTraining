package jp.mixi.practice.test.target.test;

import jp.mixi.practice.test.target.SubActivity;
import jp.mixi.practice.test.target.TestTarget1;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;

public class TestPractice1 extends AndroidTestCase {
	
	public void testIsValidIntent() {
		TestTarget1 target = new TestTarget1();
		Intent intent = new Intent();
		
		assertFalse(target.isValidIntent(intent));
		
		intent.putExtra(Intent.EXTRA_TEXT, "hoge");
		assertFalse(target.isValidIntent(intent));
		
		intent.setData(Uri.parse("file://hogehoge/"));
		assertTrue(target.isValidIntent(intent));
	}
	
	public void testStartSubActivity() {
		TestTarget1 target = new TestTarget1();
		target.startSubActivity(new TestPractice1MockContext(getContext()), "hoge");
	}
	
	class TestPractice1MockContext extends MockContext {
		private Context mContext;
		public TestPractice1MockContext(Context context) {
			mContext = context;
		}
		
		@Override
		public String getPackageName() {
			return mContext.getPackageName();
		}
		
		@Override
		public void startActivity(Intent intent) {
			ComponentName component = intent.getComponent();
			assertEquals(SubActivity.class.getCanonicalName(), component.getClassName());
			assertEquals(intent.getData().toString(), "http://mixi.jp");
			assertNotNull(intent.getFlags());
			assertTrue(intent.hasExtra(Intent.EXTRA_SUBJECT));
			assertEquals("hoge", intent.getStringExtra(Intent.EXTRA_SUBJECT));
			
		}
	}
}
