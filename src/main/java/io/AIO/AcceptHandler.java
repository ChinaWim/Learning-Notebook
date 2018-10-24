package io.AIO;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

/**
 * @author m969130721@163.com
 * @date 18-8-5 下午1:31
 */
public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
    private AsynchronousServerSocketChannel serverSocketChannel;

    ByteBuffer buff = ByteBuffer.allocate(1024);

    public AcceptHandler(AsynchronousServerSocketChannel sc) {
        this.serverSocketChannel = sc;

    }

    //当实际IO操作完成时触发该方法
    @Override
    public void completed(final AsynchronousSocketChannel sc, Object attachment) {
        //记录新连接进来的Channel
        AIOServer.channelList.add(sc);
        //准备接收客户端的下一次连接
        serverSocketChannel.accept(null, this);
        //只要这个管道有数据就会走,
        sc.read(buff, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                buff.flip();
                String content = StandardCharsets.UTF_8.decode(buff).toString();
                for (AsynchronousSocketChannel c : AIOServer.channelList) {
                    try {
                        c.write(ByteBuffer.wrap(content.getBytes(AIOServer.UTF_8))).get();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //回掉循环读取数据直到没有
                buff.clear();
                sc.read(buff,null,this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("读取数据失败"+exc);
                AIOServer.channelList.remove(sc);
            }
        });


    }

    @Override
    public void failed(Throwable exc, Object attachment) {
        System.out.println("连接失败"+exc);
    }
}
