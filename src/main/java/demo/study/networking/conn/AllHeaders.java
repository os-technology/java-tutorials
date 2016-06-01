package demo.study.networking.conn;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AllHeaders {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
			try {
				URL u = new URL(args[i]);
				HttpURLConnection http = (HttpURLConnection) u.openConnection();
				http.setRequestMethod("GET");
				for (int j = 1;; j++) {
					String header = http.getHeaderField(j);
					if (header == null)
						break;
					System.out.println(http.getHeaderFieldKey(j) + ": " + header);
				}
			} catch (MalformedURLException ex) {
				System.err.println(args[i] + " is not a URL I understand.");
			} catch (IOException ex) {
				System.err.println(ex);
			}
			System.out.println();
		}
	}

}
