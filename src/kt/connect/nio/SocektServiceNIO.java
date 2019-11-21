package kt.connect.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import kt.connect.core.SocektService;

public class SocektServiceNIO extends Thread implements SocektService {

    @Override
    public void run() {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        // len of syns quene
        bootstrap.option(ChannelOption.SO_BACKLOG, 10240);
        // close delay
        bootstrap.childOption(ChannelOption.TCP_NODELAY, true);
        // check if the connection is closed
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
//                pipeline.addLast(new LengthFieldBasedFrameDecoder());
                pipeline.addLast(new ServerHandlerNIO());
            }
        });
    }
}

