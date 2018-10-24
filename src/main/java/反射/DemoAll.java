package 反射;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;


/**
 * @author m969130721@163.com
 * @date 18-6-10 下午10:43
 */
public class DemoAll {

    @Test
    public void method1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        System.out.println();
       /* Student student = new Student();
        Field[] fields = student.getClass().getDeclaredFields();*/
//        Field[] fields1 = Class.forName("反射.Student").getDeclaredFields();
        Class<Student> studentClass = Student.class;

        //拿成员
        Field[] fields = studentClass.getDeclaredFields();//拿属性
        for (Field field : fields) {
            System.out.println("属性名字:" + field.getName());
//            field.get();
//            field.set();
        }
        //拿构造方法
        Constructor<?>[] constructors = studentClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("构造名字:" + constructor.getName());
        }
        //拿一个对象
//        Student student = studentClass.newInstance();
        Constructor<Student> declaredConstructor = studentClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Student student = declaredConstructor.newInstance();
        System.out.println(student);


        //拿普通方法
        Method[] methods = studentClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("普通方法名字:" + method.getName());
            method.setAccessible(true);
            if (method.getName().equals("compare")) {
                continue;
            }
            System.out.println(method.invoke(student));
        }
        System.out.println("---------------------");
        //拿接口
        Class<?>[] interfaces = studentClass.getInterfaces();
        Type[] genericInterfaces = studentClass.getGenericInterfaces();
        for (Type type : genericInterfaces) {
            System.out.println(type.getTypeName());
            System.out.println();
        }
        System.out.println("---------------------");

        //拿注解
        Annotation[] annotations = studentClass.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            Ming ming = (Ming) annotation;
            System.out.println(ming.value());
        }


    }

}
