/**
 * 
 */
package com.eccl.product.liujian.tutorials.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author LiuJian
 * 
 */
public class CopyBytes {

	public static void main(String[] args) throws IOException {

		System.out.println(System.getProperty("user.dir"));

		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream("src/main/resources/xanadu.txt");
			out = new FileOutputStream("src/main/resources/outagain.txt");
			int c;

			while ((c = in.read()) != -1) {
				out.write(c);
			}
			out.flush();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} finally {
				if (out != null) {
					out.close();
				}
			}
		}
	}

}
