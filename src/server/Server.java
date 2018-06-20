package server;

import message.*;
import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This is the server if the booking system, it takes commands from users and
 * pass the messages to client through socket.
 * 
 * @author Lu
 * @version 1.0
 * @since 2018-06-07
 *
 */
public class Server {

	HashMap codeMap = new HashMap<Integer, String>();
	HashMap seatMax = new HashMap<String, Integer>();

	public Server() {
		seatMax.put("NormalWin", 262);
		seatMax.put("NormalMid", 137);
		seatMax.put("NormalAisle", 265);
		seatMax.put("BusinessWin", 33);
		seatMax.put("BusinessMid", 33);
	}

	/**
	 * This function keeps listening for socket requests.
	 */
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
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Server error");
		}
	}

	/**
	 * This class is the thread that the server creates once it acquired a message
	 * from client.
	 * 
	 * @author USER
	 *
	 */
	class AddThread extends Thread {
		private Object msg;
		Socket socket;
		ObjectOutputStream os = null;
		ObjectInputStream is = null;

		/**
		 * This is the constructor.
		 * 
		 * @param sk
		 * @throws IOException
		 * @throws ClassNotFoundException
		 */
		public AddThread(Socket sk) throws IOException, ClassNotFoundException {
			socket = sk;
		}

		/**
		 * This function, depending on the message received by the server, executes the
		 * user request and returns the result if any.
		 * 
		 * @param msg
		 *            The message received by the server.
		 * @return
		 */
		private Object messageHandler(Object msg) {
			Database database = new Database();
			try {
				if (msg.getClass() == new SearchCar().getClass()) {
					
					System.out.println("Server received SearchCar!!");
					return database.selectCar((SearchCar) msg);
				} else if (msg.getClass() == new Order().getClass()) {
					int code;
					do
						code = (int) Math.random() % 10000000;
					while (codeMap.get(code) == null);
					return database.insertBooking((Order) msg, code);
				} else if (msg.getClass() == new SearchOrder().getClass()) {
					return database.searchTicketByUserId((SearchOrder)msg);
				}
				else if (msg.getClass() == new SearchTransactionNumber().getClass()) {
					return database.findTransactionNumber((SearchTransactionNumber) msg);
				}
				else if (msg.getClass() == new Ticket().getClass()) {
					return new Ticket(1, 1);
				} else
					return null;
			}
			catch(Fail_Message e) {
				System.out.println("messageHandler error");
				return e;
			}
			
		}

		/**
		 * This is the running function of the thread, it reads the object in the socket
		 * and pass it to messageHandler.
		 * 
		 */
		public void run() {
			try {
				os = new ObjectOutputStream(socket.getOutputStream());
				is = new ObjectInputStream(socket.getInputStream());
				this.msg = (Object) is.readObject();
			} catch (IOException | ClassNotFoundException e1) {
				e1.printStackTrace();
				System.out.println("input/output stream error");
			}
			Object returnMsg = messageHandler(msg);

			try {
				if (returnMsg == null)
					System.out.println("server send null object");
				//System.out.println("server send " + returnMsg.getClass().toString());
//				Available temp = (Available) returnMsg;
//				LinkedList<Car> list = temp.getAvailable();
//				for(Car car : list) {
//					System.out.println(car.getCarID());
//				}
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