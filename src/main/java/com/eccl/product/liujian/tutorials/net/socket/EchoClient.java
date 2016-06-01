/**
 * 
 */
package com.eccl.product.liujian.tutorials.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author LiuJian
 * 
 */
public class EchoClient {
	public static void main(String[] args) throws IOException {

		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedReader stdIn = null;
		try {
			try {
				echoSocket = new Socket("localhost", 7);
				out = new PrintWriter(echoSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
				System.out.println(in.readLine());
			} catch (UnknownHostException e) {
				System.err.println("Don't know about host: localhost.");
				System.exit(1);
			} catch (IOException e) {
				System.err.println("Couldn't get I/O for " + "the connection to: taranis.");
				System.exit(1);
			}

			stdIn = new BufferedReader(new InputStreamReader(System.in));
			String userInput;

			while ((userInput = stdIn.readLine()) != null) {
				if ("Bye".equalsIgnoreCase(userInput)) {
					break;
				}

				System.out.println("client:" + userInput);
				out.println(userInput);
				System.out.println("echo: " + in.readLine());
			}
		} finally {
			out.close();
			in.close();
			stdIn.close();
			echoSocket.close();
		}
	}
}
