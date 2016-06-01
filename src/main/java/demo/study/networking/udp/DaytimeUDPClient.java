package demo.study.networking.udp;

import java.io.*;
import java.net.*;

public class DaytimeUDPClient {
	private final static int PORT = 13;
	//time.nist.gov
	private static final String HOSTNAME = "localhost";

	public static void main(String[] args) {
		try (DatagramSocket socket = new DatagramSocket(0)) {
			socket.setSoTimeout(10000);
			InetAddress host = InetAddress.getByName(HOSTNAME);
			DatagramPacket request = new DatagramPacket(new byte[1], 1, host,
					PORT);
			DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
			socket.send(request);
			System.out.println("sended.");
			socket.receive(response);
			String result = new String(response.getData(), 0,
					response.getLength(), "US-ASCII");
			System.out.println(result);
			System.in.read();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
