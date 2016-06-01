package demo.study.networking.address;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressTests {
	public static int getVersion(InetAddress ia) {
		byte[] address = ia.getAddress();
		if (address.length == 4)
			return 4;
		else if (address.length == 16)
			return 6;
		else
			return -1;
	}

	public static void main(String[] args) {
		try {
			InetAddress me = InetAddress.getByName("::1");
			int version = getVersion(me);
			System.out.println(version);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
