package demo.study.networking.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * time.nist.gov
 * 
 * @author LiuJian
 *
 */
public class Daytime implements Runnable {
	private static ExecutorService service = Executors.newFixedThreadPool(8);

	private static AtomicInteger seed = new AtomicInteger(0);
	private static AtomicInteger count = new AtomicInteger(0);
	private static AtomicInteger excepTimes = new AtomicInteger(0);

	public static void main(String[] args) {

		long begin = System.currentTimeMillis();
		for (int i = 0; i < 30; i++) {
			service.execute(new Daytime(i) {
			});
		}

		try {
			service.awaitTermination(20L, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("elapse:" + (end - begin));
		System.out.println("exception times:" + excepTimes);
	}

	public Daytime() {
	}

	public Daytime(int threadNum) {
		this.thread = threadNum;
	}

	private int thread;

	@Override
	public void run() {
		int i;
		for (i = seed.incrementAndGet(); i < 100001; i = seed.incrementAndGet()) {
			this.getDateFromNetwork(i);
		}
		System.out.println(thread + " is closed." + i);
		int currCount = count.incrementAndGet();
		if (currCount == 30) {
			service.shutdownNow();
		}
	}

	public Date getDateFromNetwork(int i) {
		try (Socket socket = new Socket("localhost", 13)) {
			socket.setSoTimeout(15000);
			if (!socket.getReuseAddress())
				socket.setReuseAddress(true);
			InputStream in = socket.getInputStream();
			StringBuilder time = new StringBuilder();
			InputStreamReader reader = new InputStreamReader(in, "ASCII");
			for (int c = reader.read(); c != -1; c = reader.read()) {
				time.append((char) c);
			}
			socket.close();
			return parseDate(time.toString());
		} catch (BindException e) {
			excepTimes.incrementAndGet();
			System.out.println(i);
		} catch (SocketException e) {
			excepTimes.incrementAndGet();
			System.out.println(i);
		} catch (UnknownHostException e) {
			excepTimes.incrementAndGet();
			System.out.println(i);
		} catch (IOException e) {
			excepTimes.incrementAndGet();
			System.out.println(i);
		} catch (ParseException e) {
			excepTimes.incrementAndGet();
			System.out.println(i);
		}
		return null;
	}

	static Date parseDate(String s) throws ParseException {
		// String[] pieces = s.split(" ");
		// String dateTime = pieces[1] + " " + pieces[2] + " UTC";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.parse(s);
	}

}
