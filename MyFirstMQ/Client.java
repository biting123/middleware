package MyFirstMQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private final static int SERVER_PORT = 9999;
    //订阅
     public static void inpost(String msg) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),SERVER_PORT);
        try(
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ){
            out.println(msg);
            out.flush();
        }
    }
    //出版社送书
    public static void outpost() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),SERVER_PORT);
        try(
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ){

            out.println("PUBLISHER");
            out.flush();
            String msg = in.readLine();
        }
    }

}
