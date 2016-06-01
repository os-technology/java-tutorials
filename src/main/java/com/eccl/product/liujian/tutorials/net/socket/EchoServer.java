/**
 * 
 */
package com.eccl.product.liujian.tutorials.net.socket;

import java.net.*;
import java.io.*;

/**
 * @author LiuJian
 * 
 */
public class EchoServer {
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(7);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 7.");
			System.exit(1);
		}

		Socket clientSocket = null;
		try {
			System.out.println("accept at port 7:");
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String inputLine, outputLine;

		outputLine = "please input your words:";
		System.out.println(outputLine);
		out.println(outputLine);

		while ((inputLine = in.readLine()) != null) {
			outputLine = inputLine;
			out.println(outputLine);
			System.out.println(outputLine);
			if (outputLine.equals("Bye."))
				break;
		}

		System.out.println("bye server");
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
}
