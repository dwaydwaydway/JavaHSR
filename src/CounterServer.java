
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

			ServerSocket server = new ServerSocket(3336);
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
			try {
				os = new ObjectOutputStream(socket.getOutputStream());
				is = new ObjectInputStream(socket.getInputStream());
				this.msg = (Messenger)is.readObject();
			} catch (IOException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			if(msg == null) {
				System.out.println("null object");
			} else
				try {
					os.writeObject(msg);
					os.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			
>>>>>>> refs/heads/master
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