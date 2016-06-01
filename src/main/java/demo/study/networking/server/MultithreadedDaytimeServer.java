package demo.study.networking.server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadedDaytimeServer {
	public final static int PORT = 13;
	private final static SimpleDateFormat formatter = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	static ExecutorService service = Executors.newFixedThreadPool(30);

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(PORT)) {
			while (true) {
				try {
					Socket connection = server.accept();
					Thread task = new DaytimeThread(connection);
					service.execute(task);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		} catch (IOException ex) {
			System.err.println("Couldn't start server");
		}
	}

	private static class DaytimeThread extends Thread {
		private Socket connection;

		DaytimeThread(Socket connection) {
			this.connection = connection;
		}

		@Override
		public void run() {
			try {
				Writer out = new OutputStreamWriter(
						connection.getOutputStream());
				Date now = new Date();
				out.write(formatter.format(now) + "\r\n");
				out.flush();
			} catch (IOException ex) {
				System.err.println(ex);
			} finally {
				try {
					connection.close();
				} catch (IOException e) {
					// ignore;
					e.printStackTrace();
				}
			}
		}
	}

}
