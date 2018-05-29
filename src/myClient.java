
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class myClient {
	private static void sendObject(ObjectOutputStream oos, Messenger msg) throws IOException {
		oos.writeObject(msg);
		oos.flush();
		oos.close();
	}

	private static Messenger listen() {
		try {
			ServerSocket server = new ServerSocket(8080);
			while (true) {
				System.out.println("處理中");
				Socket socket = server.accept();
				socket.setSoTimeout(15000);
				ObjectInputStream inStream = null;
				try {
					inStream = new ObjectInputStream(socket.getInputStream());
					Messenger returnMsg = (Messenger) inStream.readObject();
					server.close();
					return returnMsg;
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("伺服器輸出入發生錯誤");
		}
		return null;
	}
	private static void messageHandler(Messenger msg) {
		NormalBooking nb = new NormalBooking();
		if(msg.getClass() == nb.getClass())
			System.out.println("return success");
	}

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("input command");
			int command = scanner.nextInt();
			scanner.close();
			Socket cs = new Socket("127.0.0.1", 3334); // Connect to Server
			ObjectOutputStream oos = new ObjectOutputStream(cs.getOutputStream());
			switch (command) {
			case 1:
				NormalBooking a = new NormalBooking();
				sendObject(oos, a);
				cs.close();
				messageHandler(listen());				
			default:
				System.out.println("command error");
			}
		} catch (UnknownHostException e) {
			System.out.println("主機連線失敗");
		} catch (IOException e) {
			System.out.println("傳輸失敗");
		}
	}

}
