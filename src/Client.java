
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private static Messenger messengerCreater() {
		return new SearchCar();
	}

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Socket cs = new Socket("127.0.0.1", 3588); 
			ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
			ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
			Messenger a = messengerCreater();
			os.writeObject(a);
			os.flush();
			Messenger msg = (Messenger) is.readObject();
			if(msg == null)
				System.out.println("client get null");
			if (msg.getClass() == new Result1().getClass()) {
				Result1 result = (Result1)msg;
				for(int i = 0; i < result.carList.size(); i++) {
					Car car = result.carList.get(i);
					System.out.println("car: " + i);
					System.out.println(car.arrive);
					System.out.println(car.depart);
				}
			}
			else
				System.out.println("can't read result1");
			os.close();
			is.close();
			cs.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("connection error");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO error");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Class Not Found error");
		}
	}
}
