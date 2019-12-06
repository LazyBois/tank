package kt.connect.nio;

import io.netty.channel.Channel;
import kt.connect.core.Connect;
import kt.connect.core.Msg;

public class ConnectNetty implements Connect {
    private final int id;
    private final Channel channel;

    public ConnectNetty(int id, Channel channel) {
        this.id = id;
        this.channel = channel;
    }

    public void writeMsg(Msg msg) {
        if (!channel.isActive() || !channel.isWritable()) {
            return;
        }

        msg.writeMsg(channel);
    }

    public void readMsg() {

    }
}
