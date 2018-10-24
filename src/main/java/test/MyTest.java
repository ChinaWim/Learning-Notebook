package test;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author m969130721@163.com
 * @date 18-9-25 下午7:57
 */
public class MyTest {

    private final Semaphore semaphore = new Semaphore(10);
    @Test
    public void test(){
        BlockingQueue arrayQueue = new ArrayBlockingQueue(10);
        BlockingQueue linkedQueue = new LinkedBlockingQueue();
        BlockingQueue priorityQueue = new PriorityBlockingQueue();
        BlockingQueue synchronousQueue = new SynchronousQueue();
    }

    @Test
    public void testSemaphore(){



    }

    @Test
    public void add() throws InterruptedException {
        semaphore.acquire();

        semaphore.release();
    }
}
