package thinkingjava.chapter09.practice;

/**
 * @author 李重辰
 * @date 2018/10/9 15:07
 */
public class P2 {
    public static void main(String[] args) {
        Child child = new Child();
        child.print();
    }
}

abstract class AbstractFather{
    /**
     * 第九章第二个练习题
     */
    abstract void print();
    AbstractFather(){
        print();
    }
}

class Child extends AbstractFather {
    private int i = 1;

    @Override
    void print() {
        System.out.println(i);
    }
}