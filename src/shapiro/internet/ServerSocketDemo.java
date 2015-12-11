package shapiro.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
	public static void main(String[] args) throws IOException {
		// server accepts connections so instead of socket use serversocket
		ServerSocket serverSocket = new ServerSocket(52746); // port number

		// need to wait for message
		// type of call that stops is called blocking call
		Socket socket = serverSocket.accept();

		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String response = reader.readLine();

		System.out.println("RESPONSE ");
		System.out.println(response);

		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write("HOW ARE YOU DOING?");
		out.flush();

		serverSocket.close();
		socket.close();

	}
}
