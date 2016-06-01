package demo.study.networking.address;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ReverseTest {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress ia = InetAddress.getByName("61.135.169.125");
		System.out.println(ia.getCanonicalHostName());
	}

}
