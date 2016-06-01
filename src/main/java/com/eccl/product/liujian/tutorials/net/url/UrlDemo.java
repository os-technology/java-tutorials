/**
 * 
 */
package com.eccl.product.liujian.tutorials.net.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

/**
 * URL Demos:
 * <ul>
 * <li><code>URL url = new URL("http://example.com/hello%20world");<code></li>
 * <li>URI uri = new URI("http", "example.com", "/hello world/", "");</li>
 * </ul>
 * 
 * @see java.net.URL
 * @see java.net.URI
 * @author LiuJian
 * 
 */
public class UrlDemo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// URL u = new URL("http://www.qq.com");
		URL u = new URL(
				"http://dict.youdao.com/search?q=Malformed&keyfrom=dict.index");

		print(u);

		// URLConnection connection = u.openConnection();
		//
		// connection.connect();

		BufferedReader reader = null;
		try {
			reader = getBufferedReader(getInputStream(u));
			print(reader);
		} finally {
			if (reader != null)
				reader.close();
		}

	}

	public static void print(URL url) {
		System.out.println("protocol = " + url.getProtocol());
		System.out.println("authority = " + url.getAuthority());
		System.out.println("host = " + url.getHost());
		System.out.println("port = " + url.getPort());
		System.out.println("path = " + url.getPath());
		System.out.println("query = " + url.getQuery());
		System.out.println("filename = " + url.getFile());
		System.out.println("ref = " + url.getRef());
	}

	static void print(BufferedReader reader) throws IOException {

		String s = reader.readLine();
		int lineNumber = 0;

		while (s != null) {
			lineNumber++;
			// if (lineNumber > 100) {
			// System.out.println("...");
			// break;
			// }
			System.out.println(lineNumber + ":" + s);
			s = reader.readLine();
		}

	}

	static InputStream getInputStream(URL url) throws IOException {
		return url.openStream();
	}

	static InputStream getInputStream(URLConnection connection)
			throws IOException {
		return connection.getInputStream();
	}

	static BufferedReader getBufferedReader(InputStream inputStream) {
		return new BufferedReader(new InputStreamReader(inputStream));
	}

	static BufferedReader getBufferedReader(InputStream inputStream,
			String charset) throws UnsupportedEncodingException {
		return new BufferedReader(new InputStreamReader(inputStream, charset));
	}
}
