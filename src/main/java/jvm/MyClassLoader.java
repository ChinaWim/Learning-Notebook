package jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

/**
 * 自己写一个类加载器 ，去加载
 *
 * @author m969130721@163.com
 * @date 18-12-8 下午7:37
 */
public class MyClassLoader extends ClassLoader {
    private static final String CLASS_PATH = "/home/ming/Desktop/";


    public MyClassLoader() {
    }

    public MyClassLoader(ClassLoader loader) {
        // 通过这个这个构造方法生成的类加载器，该
        // 加载器的父加载器是loader,如果为空，则父加载器为根加载器
        super(loader);
    }


    /**
     * 要重写findClass这个方法,loadClass会调用它
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = null;
        FileInputStream fis = null;
        try {
            String fileName = name.replaceAll("\\.","/");
            fis = new FileInputStream(CLASS_PATH + fileName + ".class");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream abos = new ByteArrayOutputStream();
        int ch = 0;
        try {
            while ((ch = fis.read()) != -1) {
                abos.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        data = abos.toByteArray();
        //第一个为权限定名
        return this.defineClass(name, data, 0, data.length, null);

    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //todo
        MyClassLoader myClassLoader = new MyClassLoader();
//        Class<?> main = myClassLoader.loadClass("jvm.hot.HelloService");
        Class<?> main = Class.forName("jvm.hot.HelloService", true,myClassLoader);
        System.out.println(main.getClassLoader());
    }
}
