package demo.study.networking.address;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class OReillyByName {

	public static void main(String[] args) {
		try {
			InetAddress address1 = InetAddress.getLocalHost();
			System.out.println(address1);
			InetAddress address2 = InetAddress.getByName("localhost");
			System.out.println(address2);

			InetAddress address3 = InetAddress.getLoopbackAddress();
			System.out.println(address3);
		} catch (UnknownHostException ex) {
			System.out.println("Could not find www.oreilly.com");
		}

		try {
			InetAddress address = InetAddress.getByName("www.ddkksksllal.com");
			System.out.println(address);
		} catch (UnknownHostException ex) {
			System.out.println("Could not find www.oreilly.com");
		}

		{
			byte[] address = { 107, 23, (byte) 216, (byte) 196 };
			try {
				InetAddress lessWrong = InetAddress.getByAddress(address);
				System.out.println(lessWrong);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			try {
				InetAddress lessWrongWithname = InetAddress.getByAddress(
						"lesswrong.com", address);
				System.out.println(lessWrongWithname);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}

		try {
			InetAddress address = InetAddress.getByName("www.oreilly.com");
			String host = address.getHostName();
			String host1 = address.getCanonicalHostName();
			System.out.println(address);
			System.out.println(host + "," + host1);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		InetAddress ia;
		try {
			ia = InetAddress.getByName("208.201.239.100");
			System.out.println(ia.getCanonicalHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}
