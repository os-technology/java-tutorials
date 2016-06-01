package demo.study.networking.server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PooledDaytimeServer {
	public final static int PORT = 13;
	private final static SimpleDateFormat formatter = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(8);
		try (ServerSocket server = new ServerSocket(PORT)) {
			while (true) {
				try {
					Socket connection = server.accept();
					if (!connection.getReuseAddress()) {
						connection.setReuseAddress(true);
					}
					DaytimeTask task = new DaytimeTask(connection);
					// pool.submit(task);
					pool.execute(task);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		} catch (IOException ex) {
			System.err.println("Couldn't start server");
		}
	}

	private static class DaytimeTask implements Callable<Void>, Runnable {
		private Socket connection;

		DaytimeTask(Socket connection) {
			this.connection = connection;
		}

		@Override
		public Void call() {
			execute();
			return null;
		}

		@Override
		public void run() {
			execute();
		}

		private void execute() {
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
				}
			}
		}
	}
}
