/**
 * 
 */
package com.eccl.product.liujian.tutorials.io.udemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 * @author LiuJian
 *
 */
public class WriteFlushDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String context = "insert into my_table values('测试中文',?,?)";
		final String filePath = "f:/" + System.currentTimeMillis() + ".txt";
		File file = new File(filePath);
		OutputStreamWriter writer = null;
		BufferedWriter bw = null;
		final int size = 1024 * 4;
		Random r = new Random();
		int j = 0;
		try {
			FileOutputStream stream = new FileOutputStream(file, true);
			writer = new OutputStreamWriter(stream);
			bw = new BufferedWriter(writer, size);

			long begin = System.currentTimeMillis();
			for (int i = 1; i < 1000001; i++) {
				bw.write(String.valueOf(i));
				bw.write('|');
				bw.write(context);
				bw.write('\n');
				if (r.nextInt() % 5 == 0) {
					bw.flush();
					j++;
				}
				if (j % 100 == 0) {
					System.out.println("i:" + i + ",j: " + j + " "
							+ System.currentTimeMillis());
				}
			}
			bw.flush();
			j++;
			long end = System.currentTimeMillis();
			System.out.println("j:" + j + "elapses:" + (end - begin));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
