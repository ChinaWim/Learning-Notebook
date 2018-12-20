package io.NIO;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.FutureTask;

/**
 * @author m969130721@163.com
 * @date 18-6-3 上午9:54
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.bind(new InetSocketAddress(9898));
        Selector selector = Selector.open();
        //注册选择器
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        //手动轮询
        //当前线程阻塞
        while (selector.select() > 0) {
            //阻塞操作,获取选择器上已经"准备就绪"的事件,当至少有一个通道被选择时才返回
            //获取多路选择器上的已选择的键集，这个键集是就绪状态的通道的集合，
            // 还有一个方法叫keys()返回的是注册到这个多路复选器上的键，不管是就绪状态的还是非就绪状态的。
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey sk = keyIterator.next();
                if (sk.isAcceptable()) {//如果有连接
                    SocketChannel socketChannel = ssc.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    new Thread(new NIOServerRead(sk)).start();
                }
                keyIterator.remove();
            }
        }
        //关闭通道
        //ssc.close();
    }
}

class NIOServerRead implements Runnable {
    //
    SelectionKey selectionKey;

    SocketChannel socketChannel;

    public NIOServerRead(SelectionKey selectionKey) {
        this.selectionKey = selectionKey;
        socketChannel = (SocketChannel) selectionKey.channel();
    }

    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            int len = 0;
            while ((len = socketChannel.read(buffer)) > 0) {
                buffer.flip();
                System.out.println(new String(buffer.array(), 0, len));
                buffer.clear();
            }
        } catch (IOException e) {
            selectionKey.cancel();
            try {
                socketChannel.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}






