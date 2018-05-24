
import java.io.BufferedReader;
import java.io.IOException;
 
    public class ReadServerMess extends Thread {
        BufferedReader in;
      public ReadServerMess(BufferedReader ss) throws IOException{
        in = ss;
      }
      public void run() {
        try {
          String data="";
          while(true){
                Thread.currentThread().sleep(50);
                if  (in.ready()){
                     data = in.readLine();
                     System.out.println("S:"+data);
                    }
                if (data.equals("exited")){
                    in.close();
                    break;
                }
            }    
        } catch (IOException e) {
          System.out.println("¿é¥X¤J¿ù»~");
        }
          catch (InterruptedException e){
        }
        System.exit(0);
      }
    }
