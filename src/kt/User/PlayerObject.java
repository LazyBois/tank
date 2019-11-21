package kt.User;

import kt.connect.core.Connect;
import kt.connect.core.Msg;

public class PlayerObject {
    private int id;
    private Connect connect;

    public PlayerObject(int id, Connect connect) {
        this.id = id;
        this.connect = connect;
    }

    public void sendMsg(Msg msg){

    }
}
