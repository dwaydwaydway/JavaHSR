
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class myClient {

    public static void main(String[] args) {
        try {
        	
            Scanner sc = new Scanner(System.in);
            Socket cs = new Socket("127.0.0.1",3336);  // Connect to Server
            ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
            NormalBooking a = new NormalBooking();
            os.writeObject(a);
            os.flush();
            Messenger msg = (Messenger)is.readObject();
            if(msg != null)
            	System.out.println("success");
            os.close();
            is.close();
        }
        catch (UnknownHostException e) {
            System.out.println("主機連線失敗");
        } 
        catch (IOException e) {
            System.out.println("傳輸失敗");
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
