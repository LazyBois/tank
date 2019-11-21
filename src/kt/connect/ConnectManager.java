package kt.connect;

import kt.connect.core.SocektService;
import kt.connect.nio.SocektServiceNIO;

public class ConnectManager {

    public static void startupListener() {
        SocektService listerner = new SocektServiceNIO();
        listerner.start();
    }

}
