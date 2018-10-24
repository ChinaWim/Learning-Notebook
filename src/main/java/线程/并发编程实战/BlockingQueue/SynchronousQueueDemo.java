package 线程.并发编程实战.BlockingQueue;

/**
 *
 * 同步队列是一个不存储元素的队列，它的size()方法总是返回0.
 * 每个线程的插入操作必须等待另一个线程的移除操作
 * 同样任何一个线程的移除操作都必须等待另一个线程的插入操作．
 * 可以认为SynchronousQueue是一个缓存值为1的阻塞队列．
 *
 *
 * @author m969130721@163.com
 * @date 18-10-14 上午10:33
 */
public class SynchronousQueueDemo {


    public static void main(String[] args) {



    }

}
