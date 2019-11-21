package kt.connect.bio;

import kt.connect.core.SocektService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocektServiceBIO implements SocektService {
    public void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(9012);
            while(true){
                Socket socket = serverSocket.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
