/**
 * 
 */
package com.eccl.product.liujian.tutorials.io.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author LiuJian
 * 
 */
public class FileSpliter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "f:/logs/";
		String fileName = "catalina.out";

		splitFile(path, fileName);
		// deleteFile(path, fileName, 1, 150);
		// rename(path, fileName);
	}

	@SuppressWarnings("unused")
	private static void rename(String path, String fileName) {
		int count = 2;
		Path file = Paths.get(path + fileName + "." + count);
		Path newFile = Paths.get(path + fileName + "." + count + ".txt");
		while (file.toFile().exists()) {
			try {
				Files.move(file, newFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			count++;
			file = Paths.get(path + fileName + "." + count);
			newFile = Paths.get(path + fileName + "." + count + ".txt");
		}
	}

	@SuppressWarnings("unused")
	private static void deleteFile(String path, String fileName, int i, int end) {
		int count = i;
		File file = new File(path + fileName + "." + count + ".txt");
		count++;
		while (file.exists()) {
			file.deleteOnExit();
			file = new File(path + fileName + "." + count + ".txt");
			count++;
			if (count >= end) {
				break;
			}
		}

	}

	private static void splitFile(String path, String fileName) {
		FileReader input = null;
		BufferedReader buffInput = null;
		PrintWriter output = null;
		int count = 1;
		int line = 0;
		try {

			File file = new File(path + fileName);
			if (file.exists()) {
				System.out.println("in read file");
				try {
					input = new FileReader(file);
				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				}
				buffInput = new BufferedReader(input);

				String l;

				try {
					while ((l = buffInput.readLine()) != null) {
						if (output == null) {
							output = new PrintWriter(new FileWriter(path
									+ fileName + "." + count + ".txt"));
							count++;
						}

						output.println(l);
						line++;
						if (line >= 1000 * 1000) {
							output.close();
							output = new PrintWriter(new FileWriter(path
									+ fileName + "." + count + ".txt"));
							count++;
							line = 0;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} finally {
			if (buffInput != null) {
				try {
					buffInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (output != null) {
				output.close();
			}
		}

	}
}
