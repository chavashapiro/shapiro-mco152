package shapiro.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketHttpRequestDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// give socket 2 arguments, address and port
		// 80 is port number of http protocol
		Socket socket = new Socket("www.google.com", 80);

		// request computer sends to server when type www.google.com into web
		// browser
		String httpRequestString = "GET /index.html\n\n";

		// send request
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write(httpRequestString);
		out.flush();

		// read response
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String s;
		while ((s = reader.readLine()) != null) {
			System.out.println(s);
		}
		socket.close();
	}
}
