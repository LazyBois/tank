package kt.connect.core;

import io.netty.channel.Channel;

public interface Msg {
    void writeMsg(Channel channel);
}
