package 设计模式.单例模式;

/**枚举
 * @author m969130721@163.com
 * @date 18-6-14 下午5:02
 */
public enum Demo5 {
    /**
     *
     */
    getInstance;

    private Demo5Instance demo5Instance;

    public Demo5Instance getDemo5Instance(){
        return demo5Instance;
    }
    Demo5() { //只初始化一次
        demo5Instance = new Demo5Instance();
    }
    public static void main(String[] args) {
        Demo5Instance demo5Instance = Demo5.getInstance.getDemo5Instance();
        Demo5Instance demo5Instance2 = Demo5.getInstance.getDemo5Instance();
        System.out.println(demo5Instance2.hashCode());
        System.out.println(demo5Instance.hashCode());
    }

}

class Demo5Instance {

}
