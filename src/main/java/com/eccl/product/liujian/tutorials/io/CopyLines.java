/**
 * 
 */
package com.eccl.product.liujian.tutorials.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * @author LiuJian
 * 
 */
public class CopyLines {
	public static void main(String[] args) throws IOException {
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader(
					"src/main/resources/xanadu.txt"));
			outputStream = new PrintWriter(new FileWriter(
					"src/main/resources/characterLineoutput.txt"));

			String l;
			while ((l = inputStream.readLine()) != null) {
				outputStream.println(l);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}
