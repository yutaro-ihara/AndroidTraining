* Service
start押した
05-15 14:01:13.649: V/StartedService(28383): onCreate
05-15 14:01:13.649: V/StartedService(28383): onStartCommand

stop押した
05-15 14:01:50.798: V/StartedService(28383): onDestroy

bind押した
05-15 14:03:07.790: V/BoundService(28383): onCreate
05-15 14:03:07.806: V/MainActivity(28383): onServiceConnected

unbind押した
05-15 14:03:44.360: V/BoundService(28383): onUnbind
05-15 14:03:44.360: V/BoundService(28383): onDestroy

call intentservice押した
05-15 14:03:53.868: V/MyIntentService(28383): onCreate
05-15 14:03:53.868: V/MyIntentService(28383): onStartCommand
05-15 14:03:53.868: V/MyIntentService(28383): onHandleIntent
05-15 14:03:53.884: V/MyIntentService(28383): onDestroy

* Loader
05-15 14:13:39.517: V/MainActivity(29122): onCreateLoader
05-15 14:13:39.517: V/MyAsyncTaskLoader(29122): onStartLoading
05-15 14:13:39.673: V/MyAsyncTaskLoader(29122): loadInBackground
05-15 14:13:40.767: V/MyAsyncTaskLoader(29122): deliverResult
05-15 14:13:40.767: V/MainActivity(29122): onLoadFinished

* AsyncTask
05-15 14:48:00.149: E/AndroidRuntime(29896): FATAL EXCEPTION: AsyncTask #5
05-15 14:48:00.149: E/AndroidRuntime(29896): java.lang.RuntimeException: An error occured while executing doInBackground()
05-15 14:48:00.149: E/AndroidRuntime(29896):                             at android.os.AsyncTask$3.done(AsyncTask.java:299)
05-15 14:48:00.149: E/AndroidRuntime(29896):                             at java.util.concurrent.FutureTask.finishCompletion(FutureTask.java:352)
05-15 14:48:00.149: E/AndroidRuntime(29896):                             at java.util.concurrent.FutureTask.setException(FutureTask.java:219)
05-15 14:48:00.149: E/AndroidRuntime(29896):                             at java.util.concurrent.FutureTask.run(FutureTask.java:239)
05-15 14:48:00.149: E/AndroidRuntime(29896):                             at android.os.AsyncTask$SerialExecutor$1.run(AsyncTask.java:230)
05-15 14:48:00.149: E/AndroidRuntime(29896):                             at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1080)
05-15 14:48:00.149: E/AndroidRuntime(29896):                             at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:573)
05-15 14:48:00.149: E/AndroidRuntime(29896):                             at java.lang.Thread.run(Thread.java:856)
05-15 14:48:00.149: E/AndroidRuntime(29896): Caused by: android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.
05-15 14:48:00.149: E/AndroidRuntime(29896):        at android.view.ViewRootImpl.checkThread(ViewRootImpl.java:4746)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at android.view.ViewRootImpl.requestLayout(ViewRootImpl.java:823)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at android.view.View.requestLayout(View.java:15473)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at android.view.View.requestLayout(View.java:15473)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at android.view.View.requestLayout(View.java:15473)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at android.view.View.requestLayout(View.java:15473)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at android.widget.RelativeLayout.requestLayout(RelativeLayout.java:318)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at android.view.View.requestLayout(View.java:15473)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at android.widget.TextView.checkForRelayout(TextView.java:6452)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at android.widget.TextView.setText(TextView.java:3696)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at android.widget.TextView.setText(TextView.java:3554)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at android.widget.TextView.setText(TextView.java:3529)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at jp.mixi.sample.async.asynctask.MainActivity$MyAsyncTask.doInBackground(MainActivity.java:62)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at jp.mixi.sample.async.asynctask.MainActivity$MyAsyncTask.doInBackground(MainActivity.java:1)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at android.os.AsyncTask$2.call(AsyncTask.java:287)
05-15 14:48:00.149: E/AndroidRuntime(29896):        at java.util.concurrent.FutureTask.run(FutureTask.java:234)
05-15 14:48:00.149: E/AndroidRuntime(29896):        ... 4 more

viewに触れるのはオリジナルのスレッドだけ