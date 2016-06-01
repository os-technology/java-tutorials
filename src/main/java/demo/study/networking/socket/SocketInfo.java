package demo.study.networking.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SocketInfo {
	public static void main(String[] args) {
		for (String host : args) {
			Socket theSocket = null;
			try {
				theSocket = new Socket(host, 80);
				System.out.println("Connected to " + theSocket.getInetAddress()
						+ " on port " + theSocket.getPort() + " from port "
						+ theSocket.getLocalPort() + " of "
						+ theSocket.getLocalAddress());
			} catch (UnknownHostException ex) {
				System.err.println("I can't find " + host);
			} catch (SocketException ex) {
				System.err.println("Could not connect to " + host);
			} catch (IOException ex) {
				System.err.println(ex);
			} finally {
				if (theSocket != null) {
					try {
						if (!(theSocket.isConnected() && ! theSocket.isClosed()))
							theSocket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
