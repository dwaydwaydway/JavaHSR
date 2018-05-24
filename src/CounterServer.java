
import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

public class CounterServer {
	public enum station {
		Nangang, Taipei, Banqiao, Taoyuan, Hsinchu, Miaoli, 
		Taichung, Tainan, Changhua, Yunlin, Chiayi, Zuoying
	}
	public enum type {
		normal, child, elder, disable
	}
	public void listen() throws ClassNotFoundException {
		try {
			ServerSocket server = new ServerSocket(3335);
			while (true) {
				System.out.println("接受連線中");
				Socket socket = server.accept();
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
		ObjectInputStream inStream = null;
		public AddThread(Socket sk) throws IOException, ClassNotFoundException {
			ObjectInputStream inStream = new ObjectInputStream(sk.getInputStream());
			this.msg = (Messenger)inStream.readObject();
		}

		public void run() {
			System.out.println(msg.getString);
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		CounterServer counter = new CounterServer();
		counter.listen();
	}
}