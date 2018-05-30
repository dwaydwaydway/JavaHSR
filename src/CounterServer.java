
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
	SearchCar SearchCar;
	
	public void listen() throws ClassNotFoundException {
		try {
			ServerSocket server = new ServerSocket(3336);
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
		Socket socket;
		ObjectOutputStream os = null;
		ObjectInputStream is = null;
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
				
			
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		CounterServer counter = new CounterServer();
		counter.listen();
	}
}