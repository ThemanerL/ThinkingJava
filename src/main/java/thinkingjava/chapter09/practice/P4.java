package thinkingjava.chapter09.practice;

/**
 * @author 李重辰
 * @date 2018/10/9 15:27
 */
public class P4 {
    public static void main(String[] args) {
        Child1 af1 = new Child1();
        Child1.print(af1);
        Child2 af2 = new Child2();
        Child2.print(af2);
    }
}

/**
 * 在为基类的方法中加上abstract声明后，就不再需要向下转型
 */
abstract class AbstractFather1{
    /**
     * 练习9.1.4
     */
    abstract void print();
}

class Child1 extends AbstractFather1{
    @Override
    void print(){
        System.out.println("Child1.print");
    }

    static void print(AbstractFather1 af1){
        af1.print();
    }
}

abstract class AbstractFather2{ }

/**
 * 创建一个静态方法，它可以接受只想基类的引用，将其向下转型到子类。
 */
class Child2 extends AbstractFather2{

    void print(){
        System.out.println("Child1.print");
    }

    static void print(AbstractFather2 af2){
        ((Child2)af2).print();
    }
}