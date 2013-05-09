package jp.mixi.assignment.notification.beg;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// TODO ここで通知を表示する
		Context context = getApplicationContext();

		NotificationManager manager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new NotificationCompat.Builder(context)
				.setAutoCancel(true).setTicker("hoge")
				.setSmallIcon(R.drawable.ic_launcher).setContentTitle("hoge")
				.setContentText(getString(R.string.notification_message))
				.setVibrate(new long[] {100, 300, 100, 300, 100})
				.build();
		manager.notify(R.string.app_name, notification);
	}
}