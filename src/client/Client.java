package client;
import java.util.*;
import message.SearchCar;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import message.*;
public class Client {
	private static Object messengerCreater() {
		return new SearchCar();
	}

	public static void main(String[] args) throws ParseException {
		try {
			Scanner sc = new Scanner(System.in);
			Socket cs = new Socket("127.0.0.1", 3588); 
			ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
			ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
			
			/**
			 * Object of SearchCar
			 */
			SearchCar a = new SearchCar();
			/**
			 * Set the depart station
			 */
			System.out.println("Please input your depart station: ");
			Scanner scanner1 = new Scanner(System.in);
			String DEPART = scanner1.nextLine();
			Station DepartStation = Station.valueOf(DEPART); 
			a.setDepart(DepartStation);
			
			/**
			 * Set the arrive station
			 */
			System.out.println("Please input your arrive station: ");
			Scanner scanner2 = new Scanner(System.in);
			String ARRIVE = scanner2.nextLine();
			Station ArriveStation = Station.valueOf(ARRIVE); 
			a.setArrive(ArriveStation);
			
			/**
			 * Input the passenger type
			 */
			System.out.println("Please input your passenger type: NORMAL/CHILD/ELDER/DISABLE/STUDENT");
			Scanner scanner3 = new Scanner(System.in);
			String PASSENGERTYPE = scanner3.nextLine();
			PassengerType passengertype = PassengerType.valueOf(PASSENGERTYPE); 
			a.setPassenerType(passengertype);
			
			/**
			 * Input the seat
			 */
			System.out.println("Please input your seat: NONE/WINDOW/AISE ");
			Scanner scanner4 = new Scanner(System.in);
			String SEAT = scanner4.nextLine();
			Seat seat = Seat.valueOf(SEAT); 
			a.setSeat(seat);
			
			/**
			 * Input the carriage
			 */
			System.out.println("Please input your carriage: STANDARD/BUSINESS ");
			Scanner scanner5 = new Scanner(System.in);
			String CARRIAGE = scanner5.nextLine();
			Carriage carriage = Carriage.valueOf(CARRIAGE); 
			a.setCarriage(carriage);
			
			/**
			 * Input the depart time
			 */
			System.out.println("Please input your depart time in the following format: \"2019.05.31-22:00\"");
			Scanner scanner6 = new Scanner(System.in);
			String DATE = scanner6.nextLine();
			SimpleDateFormat date = new SimpleDateFormat ("yyyy.MM.dd-HH:mm");
			Date Depart_time = date.parse(DATE);
			a.setDepartTime(Depart_time);
			
			/**
			 * Input the quantity
			 */
			System.out.println("Please input the quantities you want: ");
			System.out.println("Normal: ");
			Scanner scanner7 = new Scanner(System.in);
			int QuantityOfNormal = scanner7.nextInt();
			a.quantity[0] = QuantityOfNormal;
			
			System.out.println("Child: ");
			Scanner scanner8 = new Scanner(System.in);
			int QuantityOfChild = scanner8.nextInt();
			a.quantity[1] = QuantityOfChild;
			
			System.out.println("Elder: ");
			Scanner scanner9 = new Scanner(System.in);
			int QuantityOfElder = scanner9.nextInt();
			a.quantity[2] = QuantityOfElder;
			
			System.out.println("Disable: ");
			Scanner scanner10 = new Scanner(System.in);
			int QuantityOfDisable = scanner10.nextInt();
			a.quantity[3] = QuantityOfDisable;
			
			System.out.println("Student: ");
			Scanner scanner11 = new Scanner(System.in);
			int QuantityOfStudent = scanner11.nextInt();
			a.quantity[4] = QuantityOfStudent;
			
			/**
			 * Calculate the total quantity
			 */
			a.getTotal();
			
			os.writeObject(a);
			os.flush();
			Object msg = (Object) is.readObject();
			if (msg == null)
				System.out.println("null");
			if (msg.getClass() == new Available().getClass()) {
				Available result = (Available)msg;
				for(int i = 0; i < result.carList.size(); i++) {
					Car car = result.carList.get(i);
					System.out.println("car: " + i);
					System.out.println(car.arrive);
					System.out.println(car.depart);
				}
			}
			else if (msg.getClass() == new OrderResult().getClass()) {
				
			}
			else if(msg.getClass() == new Status().getClass()) {
				
			}
			else if(msg.getClass() == new AlterResult().getClass()) {
				
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
