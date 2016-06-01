package demo.study.networking.conn;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SourceViewer2 {
	public static void main(String[] args) {
		if (args.length > 0) {
			try {
				// Open the URLConnection for reading
				URL u = new URL(args[0]);
				URLConnection uc = u.openConnection();
				try (InputStream raw = uc.getInputStream()) { // autoclose
					InputStream buffer = new BufferedInputStream(raw);
					// chain the InputStream to a Reader
					Reader reader = new InputStreamReader(buffer);
					int c;
					int count = 0;
					while ((c = reader.read()) != -1 && count++ < 10000) {
						System.out.print((char) c);
					}
				}
			} catch (MalformedURLException ex) {
				System.err.println(args[0] + " is not a parseable URL");
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
	}
}
