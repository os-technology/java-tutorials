package demo.study.networking.conn;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SourceViewer3 {
	private static SimpleDateFormat formatter = new SimpleDateFormat(
			"yyyy-MM-dd HH-mm-ss");

	public static void main(String[] args) {
		long avgTime = 0;

		try (PrintStream cOut = new PrintStream(new FileOutputStream("d:/"
				+ formatter.format(new Date()) + ".txt", true))) {
			PrintStream oldOut = System.out;
			System.setOut(cOut);
			for (int i = 0; i < args.length; i++) {
				try {
					for (int k = 0; k < 10; k++) {
						// Open the URLConnection for reading
						long begin = System.currentTimeMillis();
						URL u = new URL(args[i]);
						HttpURLConnection uc = (HttpURLConnection) u
								.openConnection();
						int code = uc.getResponseCode();
						String response = uc.getResponseMessage();
						String contentType = uc.getContentType();
						String contentEncoding = uc.getContentEncoding();
						contentEncoding = contentEncoding == null ? "GBK"
								: contentEncoding;
						long length = uc.getContentLengthLong();
						for (int j = 1;; j++) {
							String header = uc.getHeaderField(j);
							String key = uc.getHeaderFieldKey(j);
							if (header == null || key == null)
								break;
							System.out.println(uc.getHeaderFieldKey(j) + ": "
									+ header);
						}
						System.out.println();
						try (InputStream in = new BufferedInputStream(
								uc.getInputStream())) {
							// chain the InputStream to a Reader
							Reader r = new InputStreamReader(in,
									contentEncoding);
							int c;
							while ((c = r.read()) != -1) {
								System.out.print((char) c);
							}
						}
						System.out.println();
						System.out.println("HTTP/1.x " + code + " " + response
								+ " " + " " + length + " " + contentEncoding
								+ " " + contentType);
						long end = System.currentTimeMillis();
						avgTime += (end - begin);
					}
					System.setOut(oldOut);
					System.out.println(avgTime / 10);
				} catch (MalformedURLException ex) {
					System.err.println(args[0] + " is not a parseable URL");
				} catch (IOException ex) {
					System.err.println(ex);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
