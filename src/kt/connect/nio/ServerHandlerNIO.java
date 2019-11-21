package kt.connect.nio;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import kt.connect.core.ServerHandler;

public class ServerHandlerNIO extends ChannelInboundHandlerAdapter implements ServerHandler {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }
}
