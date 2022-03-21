package MyFirstMQ;

import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class BrokerSever implements Runnable{

        public static int SERVICE_PORT = 9999;

        private final Socket socket;

        public BrokerSever(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream())
            ){
                while(true){
                    String str = in.readLine();
                    if(str==null){
                        continue;
                    }
                    System.out.println("接收到数据:"+str);
                    if(str.equals("PUBLISHER")){
                        Broker.outpost();
                        out.flush();
                    }else{
                        Broker.inpost(str);
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    public static void main(String[] args) throws Exception {
        ServerSocket socket =new ServerSocket(SERVICE_PORT);
        while(true){
            BrokerSever server = new BrokerSever(socket.accept());
            new Thread(server).start();
        }
    }


}
