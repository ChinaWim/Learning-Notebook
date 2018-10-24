package io.AIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author m969130721@163.com
 * @date 18-8-5 下午12:23
 */
public class AIODemo {

    @Test
    public void aioDemo() {
        try {
            //直接创建　异步serverSocketChannel
            AsynchronousServerSocketChannel serverSocketChannel =
                    AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(1000));

            //指定一个channelGroup来创建异步serverSocketChannel
            ExecutorService executorService = Executors.newFixedThreadPool(80);
            //创建异步channel组 (分组管理器，可以实现资源共享,)指定一个线程池(处理IO事件和触发CompletionHandler)
            AsynchronousChannelGroup group = AsynchronousChannelGroup.withThreadPool(executorService);
            AsynchronousServerSocketChannel channel =
                    AsynchronousServerSocketChannel.open(group).bind(new InetSocketAddress(10001));

            //accept()不阻塞线程. 但是 accept.get()会阻塞
            Future<AsynchronousSocketChannel> accept = channel.accept();
            accept.get();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void simpleAIOServer() {
        try {
            AsynchronousServerSocketChannel serverSocketChannel =
                    AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(10001));
            while (true) {
                Future<AsynchronousSocketChannel> future = serverSocketChannel.accept();
                System.out.println("get()方法阻塞");
                AsynchronousSocketChannel socketChannel = future.get();
                System.out.println("有Client进来啦");
                socketChannel.write(ByteBuffer.wrap("Hello".getBytes("utf-8"))).get();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void simpleAIOClient() {
        try {
            AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 10001)).get();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            socketChannel.read(byteBuffer).get();
            byteBuffer.flip();
            Charset charset = Charset.forName("utf-8");
            System.out.println(charset.decode(byteBuffer));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
