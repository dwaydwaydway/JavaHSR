
import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

public class CounterServer {
	public enum station {
		Nangang, Taipei, Banqiao, Taoyuan, Hsinchu, Miaoli, Taichung, Tainan, Changhua, Yunlin, Chiayi, Zuoying
	}

	public enum type {
		normal, child, elder, disable
	}

	SearchCar SearchCar;
	static NormalBooking nb = new NormalBooking();

	public void listen() throws ClassNotFoundException {
		try {
			ServerSocket server = new ServerSocket(3334);
			while (true) {
				System.out.println("接受連線中");
				Socket socket = server.accept();
				System.out.println("connected");
				socket.setSoTimeout(15000);
				AddThread add = new AddThread(socket);
				add.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("伺服器輸出入發生錯誤");
		}
	}

	class AddThread extends Thread {
		private Messenger msg;
		Socket socket;

		public AddThread(Socket sk) throws IOException, ClassNotFoundException {
			socket = sk;
		}

		public void run() {
			ObjectInputStream inStream = null;
			try {
				inStream = new ObjectInputStream(socket.getInputStream());
				this.msg = (Messenger) inStream.readObject();
				socket.close();
				if (msg == null)
					System.out.println("server get nothing");
				else
					System.out.println("server get object");
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			if (msg.getClass() == nb.getClass()) {
				nb = (NormalBooking) msg;
				System.out.println("sending success");
				returnMessage(msg);
			}
			System.out.println(msg.getString);
		}
	}

	private static void sendObject(ObjectOutputStream oos, Messenger msg) throws IOException {
		oos.writeObject(msg);
		oos.flush();
		oos.close();
	}

	private static void returnMessage(Messenger msg) {
		Socket cs = null;
		try {
			cs = new Socket("127.0.0.1", 8080);
		} catch (IOException e) {
			e.printStackTrace();
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(cs.getOutputStream());
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				sendObject(oos, msg);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		CounterServer counter = new CounterServer();
		counter.listen();
	}
}