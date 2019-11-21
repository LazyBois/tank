package kt;

import kt.connect.ConnectManager;

public abstract class Startup {
    public static void main(String[] args) {
        System.out.println("prepare startup server...");

        ConnectManager.startupListener();

        System.out.println("startup server success");
    }
}
