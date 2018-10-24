package 语法.深拷贝和浅拷贝;

/**
 * @author m969130721@163.com
 * @date 18-6-14 上午12:19
 */
public class Car implements Cloneable {

    private Integer money;

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Car{" +
                "money=" + money +
                '}';
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }
}
