package demo.study.networking.conn;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class EncodingAwareSourceViewer {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			try {
				// set default encoding
				String encoding = "utf-8";
				URL u = new URL(args[i]);
				URLConnection uc = u.openConnection();
				String contentType = uc.getContentType();
				int encodingStart = contentType.indexOf("charset=");
				if (encodingStart != -1) {
					encoding = contentType.substring(encodingStart + 8);
				}
				System.out.println("ascii");
				InputStream in = new BufferedInputStream(uc.getInputStream());
				Reader r = new InputStreamReader(in, encoding);
				int c;
				int count = 0;
				while ((c = r.read()) != -1 && count++ < 1500) {
					System.out.print((char) c);
				}
				r.close();
			} catch (MalformedURLException ex) {
				System.err.println(args[0] + " is not a parseable URL");
			} catch (UnsupportedEncodingException ex) {
				System.err
						.println("Server sent an encoding Java does not support: "
								+ ex.getMessage());
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
	}
}
