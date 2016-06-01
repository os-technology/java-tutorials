package demo.study.networking.address;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IBiblioAliases {
	public static void main(String args[]) {
		try {
			InetAddress ibiblio = InetAddress.getByName("127.0.0.1");
			InetAddress helios = InetAddress.getByName("localhost");
			if (ibiblio.equals(helios)) {
				System.out
						.println("www.ibiblio.org is the same as helios.ibiblio.org");
			} else {
				System.out
						.println("www.ibiblio.org is not the same as helios.ibiblio.org");
			}
		} catch (UnknownHostException ex) {
			System.out.println("Host lookup failed.");
		}
	}
}
