

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
public class myClient {
    public static void main(String[] args) {
        try {
        	
            Scanner sc = new Scanner(System.in);
            Socket cs = new Socket("127.0.0.1",3335);  // Connect to Server
            ObjectOutputStream oos = new ObjectOutputStream(cs.getOutputStream());
            NormalBooking a = new NormalBooking();
            oos.writeObject(a);
            oos.flush();
            oos.close();
        }
        catch (UnknownHostException e) {
            System.out.println("主機連線失敗");
        } 
        catch (IOException e) {
            System.out.println("傳輸失敗");
        }
    }
}
