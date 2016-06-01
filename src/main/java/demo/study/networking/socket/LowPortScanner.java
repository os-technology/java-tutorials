package demo.study.networking.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;

public class LowPortScanner extends Thread {

	private static AtomicInteger port = new AtomicInteger(0);
	private static String host;

	public static void main(String[] args) {
		host = args.length > 0 ? args[0] : "localhost";
		for (int i = 0; i < 1500; i++) {
			LowPortScanner t = new LowPortScanner();
			t.start();
		}
	}

	@Override
	public void run() {
		for (int i = port.incrementAndGet(); i < 65535; i = port
				.incrementAndGet()) {
			try {
				Socket s = new Socket(host, i);
				System.out.println("There is a server on port " + i + " of "
						+ host);
				s.close();
			} catch (UnknownHostException ex) {
				// System.err.println(ex);
				ex.printStackTrace();
				break;
			} catch (IOException ex) {
				if (i % 1000 == 0) {
					System.out.println("at port" + i);
				}
			}
		}
	}
}
