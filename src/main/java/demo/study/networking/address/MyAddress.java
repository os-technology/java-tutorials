package demo.study.networking.address;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyAddress {
	public static void main(String[] args) {
		try {
			InetAddress me = InetAddress.getLocalHost();
			String dottedQuad = me.getHostAddress();
			System.out.println("My address is " + dottedQuad
					+ ",CanonicalHostName is " + me.getCanonicalHostName());
		} catch (UnknownHostException ex) {
			System.out.println("I'm sorry. I don't know my own address.");
		}
	}
}
