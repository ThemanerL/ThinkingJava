package jdk8characteristic;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用:若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”
 * 可以理解为方法引用是Lambda表达式的另外一种表现形式
 * <p>
 * 主要有三种语法格式:
 * 注意:Lambda的接口参数和返回值类型要与当前调用的方法的参数和返回值的类型相同
 * 1. 对象::实例方法名
 * 2. 类名::静态方法名
 * 3. 类名::实例方法名
 *
 * @author 李重辰
 * @date 2019/5/15 22:18
 */
public class MethodRefTest {

    /**
     * 类名::静态方法名
     */
    @Test
    public void test1() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        PrintStream stream = System.out;
        Consumer<String> consumer1 = stream::println;
        consumer1.accept("I don't like you any more.");
    }

    /**
     * 类名::静态方法名
     */
    @Test
    public void test2() {
        Employee employee = new Employee("珍妮弗", 12, 2312);
        Supplier<String> supplier = () -> employee.getName();

        Supplier<Integer> supplier2 = employee::getAge;
        Integer integer = supplier2.get();
        System.out.println(integer);
    }

    /**
     * 类::静态方法名
     */
    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> comparator1 = Integer::compare;
    }

    /**
     * 类名::实例名
     * 当第一个参数是方法的调用者，第二个参数是方法的入参时就可以使用类名::实例方法的方式
     */
    @Test
    public void test4(){
        BiPredicate<String, String> biPredicate = (x,y) -> x.equalsIgnoreCase(y);
        biPredicate.test("A","a");
        BiPredicate<String, String> biPredicate1 = String::equals;
    }
}
