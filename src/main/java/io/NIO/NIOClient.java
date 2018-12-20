package io.NIO;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * @author m969130721@163.com
 * @date 18-6-3 上午9:54
 */
public class NIOClient {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        socketChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String username = UUID.randomUUID().toString().replace("-","");
        //发数据
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String content = cin.nextLine();
            buffer.put(("["+LocalDateTime.now().toString() + "]" +username+"说: "+ content).getBytes());
            buffer.flip();
            socketChannel.write(buffer);
//            socketChannel.shutdownOutput();
            buffer.clear();

        }
        socketChannel.close();
    }


}
