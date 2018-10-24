package 语法;

import java.sql.SQLException;

/**
 * @author m969130721@163.com
 * @date 18-9-29 下午8:44
 */
public class ExtendDemo {

    static void method(){
    }
    public static void main(String[] args){
        Father obj = new Child3();
        System.out.println(obj instanceof Father);
        System.out.println(obj instanceof Child1);

        System.out.println(obj instanceof Child2);
        System.out.println(obj instanceof Child3);

    }

}

class Father{
}

class Child1 extends Father{

}

class Child2 extends Father{

}

class Child3 extends Child1{

}
