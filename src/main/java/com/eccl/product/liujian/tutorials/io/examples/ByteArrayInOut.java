package com.eccl.product.liujian.tutorials.io.examples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ByteArrayInOut {

	static public void main(String... args) {
		String originString = "这是一个原始的字符串。";
		System.out.println("in main ");
		try {
			byte[] gbkBytes = originString.getBytes("GBK");
			System.out.println(gbkBytes.length);
			byte[] defaultBytes = originString.getBytes();
			System.out.println(defaultBytes.length);
			byte[] utf8Bytes = originString.getBytes("UTF-8");
			System.out.println(utf8Bytes.length);

			ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream(
					utf8Bytes.length);
			byteArrayOutput.write(utf8Bytes);
			byte[] result = byteArrayOutput.toByteArray();
			System.out.println(new String(result, "UTF-8"));

			byteArrayOutput.close();
			byte[] inputResult = new byte[gbkBytes.length];
			ByteArrayInputStream input = new ByteArrayInputStream(gbkBytes);
			input.read(inputResult);
			inputResult.clone();
			System.out.println(new String(inputResult, "GBK"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
