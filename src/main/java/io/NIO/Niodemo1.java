package io.NIO;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * NIO的 buffer api使用　　
 * @author m969130721@163.com
 * @date 18-6-1 下午5:29
 */
public class Niodemo1 {

    @Test
    public void test1() {

        IntBuffer buffer = IntBuffer.allocate(10);
        buffer.put(99);
        System.out.println(buffer.get() +" get");
        System.out.println(buffer.position() +" postion");
        System.out.println(buffer.limit() +" limit");
        System.out.println(buffer.capacity()+" capacity");
    }


    @Test
    public void test2() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(7);
        byteBuffer.limit(4);
        byteBuffer.put("abcd2".getBytes());
        System.out.println(byteBuffer.position());

    }

    @Test
    public void test3() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("Hello World".getBytes());

        byteBuffer.flip();
        System.out.println(byteBuffer.limit());
        byteBuffer.clear();
        System.out.println(byteBuffer.limit());
        byteBuffer.put("123".getBytes());
        byteBuffer.flip();
        System.out.println(byteBuffer.limit());
        System.out.println();
    }

    @Test
    public void test4(){
        Path path = Paths.get(".");
        System.out.println(path.getRoot());
        System.out.println(path.getParent());
        System.out.println(path.getFileSystem());
        System.out.println(path.getFileName());

        Integer t1 = 100;
        System.out.println(t1.hashCode());
        Integer t2 =  100;
        System.out.println(t2.hashCode());
        System.out.println(t1 == t2);

    }

}
