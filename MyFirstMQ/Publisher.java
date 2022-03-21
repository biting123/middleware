package MyFirstMQ;

import java.io.IOException;

public class Publisher {
    public static void main(String[] args) throws IOException {
        Client client=new Client();
        client.outpost();
    }

}
