/**
 * 
 */
package demo.study.networking.http;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author LiuJian
 *
 */
public class TomcatRequests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TomcatRequests ins = new TomcatRequests();

		try {
			ins.doRequests();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void doRequests() throws IOException {
		long threadId = Thread.currentThread().getId();
		URL url = new URL("http://192.168.0.105/");
		URLConnection connection;
		// long totalCount;
		// byte[] bytes = new byte[4096];
		// int count;
		// InputStream input = null;
		System.out.println("begin:" + System.currentTimeMillis());
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			try {
				try {
					connection = url.openConnection();
				} catch (IOException e) {
					connection = null;
					e.printStackTrace();
				}
				connection.connect();
				// Object content = connection.getContent();
				// input = connection.getInputStream();
				// totalCount = 0;
				// // String encoding = connection.getContentEncoding();
				// count = input.read(bytes);
				// while (count != -1) {
				// totalCount += count;
				// count = input.read(bytes);
				// }
				// System.out.println(totalCount);
			} finally {
				/*
				 * if (input != null) input.close();
				 */
			}
			if (i % 1000 == 0 && i != 0) {
				System.out.println("id:" + threadId + ",times:" + i);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("id:" + threadId + ",elapses:" + (end - begin));
	}
}
