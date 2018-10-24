package io.AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author m969130721@163.com
 * @date 18-8-5 下午1:15
 */
public class AIOServer {

    static final int PROT = 30000;
    static final String UTF_8 = "utf-8";
    static List<AsynchronousSocketChannel> channelList = new ArrayList<>();

    public void startListen() throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(80);
        AsynchronousChannelGroup channelGroup =
                AsynchronousChannelGroup.withThreadPool(executor);
        AsynchronousServerSocketChannel socketChannel =
                AsynchronousServerSocketChannel.open(channelGroup).bind(new InetSocketAddress(PROT));
        socketChannel.accept(null, new AcceptHandler(socketChannel));
    }

    public static void main(String[] args) throws IOException {
        AIOServer aioServer = new AIOServer();
        aioServer.startListen();
        while(true){

        }
    }

}
