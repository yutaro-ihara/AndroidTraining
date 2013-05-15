package jp.mixi.practice.network.networkpractice1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

public class NetworkAsyncTaskLoader extends AsyncTaskLoader<String> {

	private String urlString;
	private String method;
	private String param;

	public NetworkAsyncTaskLoader(Context context, String method,
			String urlString, String param) {
		super(context);
		this.urlString = urlString;
		this.method = method;
		this.param = param;
	}

	@Override
	public String loadInBackground() {
		URL url = null;
		HttpURLConnection connection = null;
		Log.v(NetworkAsyncTaskLoader.class.getSimpleName(), "start");
		try {
			url = new URL(urlString);
			connection = (HttpURLConnection) url.openConnection();

			if (method.toLowerCase(Locale.US).equals("get")) {
				connection.connect();
			} else if (method.toLowerCase(Locale.US).equals("post")) {
				connection.setRequestMethod(method);
				connection.setDoOutput(true);

				OutputStream out = connection.getOutputStream();
				out.write(param.getBytes());
				out.flush();
				out.close();
			}

			InputStream in = connection.getInputStream();

			StringBuilder sbuf = new StringBuilder();
			while (true) {
				byte[] bytes = new byte[1024];
				int size = in.read(bytes);
				if (size <= 0)
					break;
				sbuf.append(new String(bytes, "euc-jp"));
			}
			Log.v(NetworkAsyncTaskLoader.class.getSimpleName(), sbuf.toString());
			return sbuf.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}

		return null;
	}

	@Override
	public void deliverResult(String data) {
		super.deliverResult(data);
	}

	@Override
	protected void onStartLoading() {
		super.onStartLoading();
		forceLoad();
	}

}
