package demo.study.networking.udp;

import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPPortScanner {
	public static void main(String[] args) {
		int count = 0;
		for (int port = 1; port <= 10000; port++) {
			try {
				// the next line will fail and drop into the catch block if
				// there is already a server running on port i
				DatagramSocket server = new DatagramSocket(port);
				server.close();
			} catch (SocketException ex) {
//				ex.printStackTrace();
				System.out.println("There is a server on port " + port + ".");
				count++;
			}
		}
		System.out.println("total count:" + count);
	}
}
