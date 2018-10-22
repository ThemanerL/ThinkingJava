package thinkingjava.chapter10.practice.p6.p3;

import thinkingjava.chapter10.practice.p6.p2.ClassSixTwo;
import thinkingjava.chapter10.practice.p6.p1.InterfaceOne;

/**
 * protected修饰的内部类没有定义任何构造函数，Java的编译器会默认的给类生成一个空参数构造函数，而这个构造函数的访问
 * 级别与类访问基本级别是相同的，所以报错。因为ClassSixThree不是Inner的子类且与ClassSixTwo不在同一个包内
 * 此时可以给Inner对象增加一个public的构造器
 * ClassSixTwo.Inner inner = classSixTwo.new Inner();
 * @author 李重辰
 * @date 2018/10/22 14:48
 */
public class ClassSixThree extends ClassSixTwo {
    private InterfaceOne getInterfaceOne() {
        ClassSixTwo classSixTwo = new ClassSixTwo();

        return classSixTwo.getInstance();
    }

    public static void main(String[] args) {
        ClassSixThree classSixThree = new ClassSixThree();
        classSixThree.getInterfaceOne().printName();
    }
}
