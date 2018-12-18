package io.NIO.复习;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author m969130721@163.com
 * @date 18-9-23 下午1:45
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);//扣分
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",12345));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        while((selector.select()) > 0){//扣分
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey selectionKey = keyIterator.next();
                if(selectionKey.isAcceptable()) {//如果有连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()){ //如果可以读
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                    ByteBuffer byteBUffer = ByteBuffer.allocate(1024);
                    int length = 0;
                    while ((length = socketChannel.read(byteBUffer)) > 0) {
                        byteBUffer.flip();
                        System.out.println(new String(byteBUffer.array(),0,length));
                        byteBUffer.clear();
                    }
                    socketChannel.shutdownInput();
                }
                keyIterator.remove();
            }

        }





    }

}
