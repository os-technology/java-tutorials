/**
 * 
 */
package com.eccl.product.liujian.tutorials.io;

import java.io.*;
import java.util.Scanner;

/**
 * @author LiuJian
 * 
 */
public class ScanXan {
	public static void main(String[] args) throws IOException {

		Scanner s = null;

		try {
			s = new Scanner(new BufferedReader(new FileReader(
					"src/main/resources/xanadu.txt")));
			s.useDelimiter(",\\s*");
			while (s.hasNext()) {
				System.out.println(s.next());
			}
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
}
