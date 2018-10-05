package thinkingjava.chapter08;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 构造工作一经发生,那么对象所有部分的全体成员都会得到构建,
 * 1) 调用基类的构造器,这个步骤会不断的反复递归下去,从更到下层导出类,直到最低层的导出类.
 * 2) 按声明顺序调用成员的初始化方法
 * 3) 调用导出类构造器的主体
 * @author 李重辰
 * @date 2018/10/4 11:01
 */
public class Sandwich extends PortableLunch{
    private Bread bread = new Bread();
    private Cheese cheese = new Cheese();
    private Lettue lettue = new Lettue();

    public Sandwich() {
        System.out.println("Sandwich.Sandwich");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}

class Meal{
    public Meal() {
        System.out.println("Meal.Meal");
    }
}

class Bread{
    public Bread() {
        System.out.println("Bread.Bread");
    }
}

class Cheese{
    public Cheese() {
        System.out.println("Cheese.Cheese");
    }
}

class Lettue{
    public Lettue() {
        System.out.println("Lettue.Lettue");
    }
}

class Lunch extends Meal{
    public Lunch() {
        System.out.println("Lunch.Lunch");
    }
}

class PortableLunch extends Lunch{
    public PortableLunch() {
        System.out.println("PortableLunch.PortableLunch");
    }
}