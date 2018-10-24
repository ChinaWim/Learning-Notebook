package io.NIO.复习;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author m969130721@163.com
 * @date 18-9-23 下午1:23
 */
public class NIOClient {


    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",12345));
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(new String("Hello NIO").getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        socketChannel.shutdownOutput();

    }

}
