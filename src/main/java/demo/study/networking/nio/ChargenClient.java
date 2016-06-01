package demo.study.networking.nio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class ChargenClient {
	public static int DEFAULT_PORT = 19;

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: java ChargenClient host [port]");
			return;
		}
		int port;
		try {
			port = Integer.parseInt(args[1]);
		} catch (RuntimeException ex) {
			port = DEFAULT_PORT;
		}
		SocketChannel client = null;
		try {
			ByteArrayOutputStream stream = new ByteArrayOutputStream(1024 * 1024 * 1024 + 1024 * 1024 * 10);
			SocketAddress address = new InetSocketAddress(args[0], port);
			client = SocketChannel.open(address);
			client.configureBlocking(false);
			ByteBuffer buffer = ByteBuffer.allocate(74);
			System.out.println(stream.size());
			WritableByteChannel out = Channels.newChannel(/* System.out */stream);
			long bytes = 0L;
			System.out.println("begin sending:");
			long begin = System.currentTimeMillis();
			// int count = 0;
			while (true) {
				// Put whatever code here you want to run every pass through the
				// loop whether anything is read or not
				int n = client.read(buffer);
				if (n > 0) {
					bytes += n;
					buffer.flip();
					out.write(buffer);
					buffer.clear();
				} else if (n == -1) {
					// This shouldn't happen unless the server is misbehaving.
					break;
				}
				// if (count++ % (1024 * 128) == 0)
				// System.out.println(count + "," + bytes);
				if (bytes > 1024 * 1024 * 10) {
					break;
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("bytes:" + bytes + ",elapse:" + (end - begin));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (client != null)
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
