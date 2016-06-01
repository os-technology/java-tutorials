package demo.study.networking.server;

import java.io.IOException;
import java.net.ServerSocket;

public class RandomPort {
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(0);
			System.out.println("This server runs on port " + server.getLocalPort());
		} catch (IOException ex) {
			System.err.println(ex);
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
