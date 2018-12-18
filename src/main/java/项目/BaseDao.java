package 项目;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Ming on 2017/8/22.
 */


public class BaseDao<T>{
    private Class targetClass;
    private String tableName;

    //通用的查找根据id 查找对象
    public T findById(String id) throws Exception {

        //获取表名
        setTableName();
        String idName = targetClass.getDeclaredFields()[0].getName();
        String sql = "select * from " + tableName + " where " + idName + " = ? ";
        System.out.println(sql);
        return null;
    }

    //通用的删除
    public boolean deleteById(String id) throws Exception {
        setTableName();
        String idName = targetClass.getDeclaredFields()[0].getName();
        String sql = "delete from " + tableName + " where  " + idName + " = ?";
        System.out.println(sql);
        return false;
    }

    //通用的查找所有
    public List<T> findAll() throws Exception {
        setTableName();
        String sql = "select * from " + tableName;
        System.out.println(sql);
        return null;
    }

    //通用的增加
    public boolean save(T t) throws Exception {
        setTableName();
        Field[] declaredFields = targetClass.getDeclaredFields();
        int length = declaredFields.length;//取多少个问号
        //设sql
        String mark = "";
        for (int i = 0; i < length; i++) {
            mark += "?,";
        }
        mark = mark.substring(0, mark.length() - 1);
        String sql = "insert into " + tableName + " values (" + mark + ")";
        //设 插入的值
        Object object[] = new Object[length];// 插入的数
        int i = 0;
        for (Field declaredField : declaredFields) {
            String fieldName = declaredField.getName();
            char c = Character.toUpperCase(fieldName.charAt(0));
            fieldName = c + fieldName.substring(1, fieldName.length());

            //拿get方法,没有参数
            Method method = targetClass.getDeclaredMethod("get" + fieldName);
            Object value = method.invoke(t);
            object[i++] = value;
            System.out.println(method.getName() + ":" + value);
        }
        System.out.println(sql);
        return false;
    }

    //通用的更新
    public boolean update(T t) throws Exception {
        setTableName();
        //设置 sql
        String sqlParam = "";
        Field[] declaredFields = targetClass.getDeclaredFields();
        //获取参数
        Object ob[] = new Object[declaredFields.length + 1];
        int i = 0;
        for (Field declaredField : declaredFields) {
            sqlParam += declaredField.getName() + " = ?,";
            String methodName = declaredField.getName();
            methodName = Character.toUpperCase(methodName.charAt(0)) + methodName.substring(1, methodName.length());
            methodName = "get" + methodName;
            Method method = targetClass.getMethod(methodName);
            Object invokeValue = method.invoke(t);
            System.out.println(methodName + ":" + invokeValue);
            ob[i++] = invokeValue;
        }
        ob[i] = ob[0];
        //去掉 分号
        String idName = declaredFields[0].getName();//id名字
        sqlParam = sqlParam.substring(0, sqlParam.length() - 1) + " where " + idName + " = ?";
        String sql = "update " + tableName + " set " + sqlParam;

        System.out.println(sql);

        return false;
    }

    //获取泛型参数类名
    private void setTableName() {
        Class aClass = this.getClass();
        //getGenericSuperclass()获得带有泛型的父类
        //Type是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
        Type type = aClass.getGenericSuperclass();
        //ParameterizedType参数化类型，即泛型
        ParameterizedType paramertype = (ParameterizedType) type;
        //getActualTypeArguments获取参数化类型的数组，泛型可能有多个
        Type[] types = paramertype.getActualTypeArguments();
        Type target = types[0];
        //本身就是个Class 再getClass()会返回 java.lang.Class
        //Class classes =  target.getClass();
        //强转成 class类型
        targetClass = (Class) target;
        tableName = targetClass.getSimpleName().toLowerCase();
    }

}
