
package jp.mixi.assignment.notification.med;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class MainActivity extends Activity {
    public static final String ACITON_VIEW_MY_OWN = "jp.mixi.assignment.notification.med.android.intent.action.VIEW_MY_OWN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO ここで通知を表示する
        // TODO intent には、ACTION_VIEW_MY_OWN の action をセットするだけにしておく
        // TODO 通知をタップした時に、複数の選択肢が表示されるが、どれがどの Activity に対応しているかがわかりづらくなっているので、AndroidManifest を編集して表示をわかりやすくする
        Context context = getApplicationContext();
		Intent intent = new Intent(ACITON_VIEW_MY_OWN);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
				intent, 0);

		NotificationManager manager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new NotificationCompat.Builder(context)
				.setAutoCancel(true).setTicker("hoge")
				.setSmallIcon(R.drawable.ic_launcher).setContentTitle("hoge")
				.setContentText("hogehoge")
				.setContentIntent(contentIntent).build();
		manager.notify(R.string.app_name, notification);
    }
}