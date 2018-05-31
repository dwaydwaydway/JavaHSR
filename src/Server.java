
import java.io.*;


import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;

public class Server {

	public void listen() {
		try {
			ServerSocket server = new ServerSocket(3588);
			while (true) {
				System.out.println("listening");
				Socket socket = server.accept();
				socket.setSoTimeout(15000);
				AddThread add = new AddThread(socket);
				add.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Server error");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ClassNotFoundException");
		}
	}

	class AddThread extends Thread {
		private Messenger msg;
		Socket socket;
		ObjectOutputStream os = null;
		ObjectInputStream is = null;

		public AddThread(Socket sk) throws IOException, ClassNotFoundException {
			socket = sk;
		}
		private Messenger messageHandler(Messenger msg) {
			Database database = new Database();
			if(msg.getClass() == new SearchCar().getClass()) {
				return database.selectCar((SearchCar)msg);
			}
			else
				return null;
		}
		public void run() {
			try {
				os = new ObjectOutputStream(socket.getOutputStream());
				is = new ObjectInputStream(socket.getInputStream());
				this.msg = (Messenger) is.readObject();
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println("input/output stream error");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("readObject error");
			}
			Messenger returnMsg = messageHandler(msg);

			try {
				if(returnMsg == null)
					System.out.println("server send null");
				os.writeObject(returnMsg);
				os.flush();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("return message IO error");
			}

		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Server server = new Server();
		server.listen();
	}
}