package jvm.hot;

import jvm.MyClassLoader;

import java.io.File;

/**
 * @author m969130721@163.com
 * @date 18-12-11 上午10:48
 */
public class HotDeployDemo {

    private static final String CLASS_NAME = "jvm.hot.HelloService";

    private static final String FILE_NAME = "/home/ming/Desktop/" + CLASS_NAME.replaceAll("\\.", "/") + ".class";

    private static volatile IHelloService helloService;


    public static IHelloService getHelloService() {
        if (helloService == null) {
            synchronized (HotDeployDemo.class) {
                if (helloService == null) {
                    helloService = createHelloService();
                }
            }
        }
        return helloService;
    }

    private static IHelloService createHelloService() {
        try {
            MyClassLoader classLoader = new MyClassLoader();
            System.out.println(classLoader);
            Class<?> cls = Class.forName(CLASS_NAME, true, classLoader);
//            Class<?> cls = c1.loadClass(CLASS_NAME);
            if (cls != null) {
                return (IHelloService) cls.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void client() {
        new Thread(() -> {
            while (true) {
                IHelloService helloService = getHelloService();
                helloService.sayHello();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }).start();
    }

    public static void monitor() {
        new Thread(new Runnable() {
            private long lastModified = new File(FILE_NAME).lastModified();

            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(100);
                        long now = new File(FILE_NAME).lastModified();
                        if (lastModified != now) {
                            System.out.println("监视更换啦");
                            lastModified = now;
                            reloadHelloService();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }).start();


    }

    public static void reloadHelloService() {
        helloService = createHelloService();
    }

    public static void main(String[] args) {
        monitor();
        client();
    }
}
