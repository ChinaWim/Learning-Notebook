package jni;

/**
 * @author m969130721@163.com
 * @date 18-12-20 下午5:00
 */
public class HelloNative {

    static {
        System.loadLibrary("HelloNative");
    }

    public static native String helloNative();


    public static void main(String[] args){
        helloNative();







    }




}
