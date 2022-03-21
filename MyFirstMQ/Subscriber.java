package MyFirstMQ;

import java.io.IOException;

public class Subscriber {
    public static void main(String[] args) throws IOException {
        Client client=new Client();
        client.inpost("小明");
    }

}
