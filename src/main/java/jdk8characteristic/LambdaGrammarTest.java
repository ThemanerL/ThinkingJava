package jdk8characteristic;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Lambda表达式的语法
 * <p>
 * 注意:在匿名内部类之中调用同级别的局部变量只能使用final类型的变量
 *
 * @author 李重辰
 * @date 2019/5/13 23:50
 */
public class LambdaGrammarTest {
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lambda!");
            }
        };

        Runnable runnable1 = () -> System.out.println("Hello Lambda!");

        runnable.run();
        runnable1.run();
    }

    /**
     * 若Lambda只有一个参数，则小括号可以省略不写
     */
    @Test
    public void test2() {
        Consumer<String> consume = x -> System.out.println(x);
        consume.accept("若Lambda只有一个参数，则小括号可以省略不写");
    }

    /**
     * 若Lambda只有一条一句，则大括号和return都可以省略
     */
    @Test
    public void test3() {
        Comparator<Integer> comparable = (x, y) -> Integer.compare(x, y);
    }

    /**
     * 练习1
     * 调用Collections.sort()方法，通过定制排序比较两个Employee(先按年龄比，年龄相同按姓名比)
     */
    @Test
    public void practice() {
        List<Employee> list = Arrays.asList(
            new Employee("joey", 12, 30000),
            new Employee("Tom", 43, 12000),
            new Employee("Aha", 18, 3000.1),
            new Employee("Ka", 34, 21000),
            new Employee("John", 45, 12000));

        list.sort((x, y) -> {
            if (x.getAge() > y.getAge()) {
                return 1;
            } else if (x.getAge() < y.getAge()) {
                return -1;
            }
            return Integer.compare(x.getName().length(), y.getName().length());
        });
        list.forEach(System.out::println);
    }

    @Test
    public void practiceSecond() {
        System.out.println(TestLambda.alterString("of course, I still love you", (s) -> s.toUpperCase()));
        System.out.println("----------------------");
        System.out.println(TestLambda.alterString("of||course, I still love you", (s) -> s.substring(2, 4)));
    }

    @Test
    public void practiceThird() {
        System.out.println(TestLambda.calculate(2.1,3.8,(x,y)->(int) (x*y)));
        System.out.println("----------------------");
        System.out.println(TestLambda.calculate(2.1,3.8,(x,y)->(int) (x+y)));
    }


    /**
     * 练习2
     * 声明函数式接口，接口中声明抽象方法，类中编写方法使用接口作为参数，将一个字符串转化为大写，并作为方法的返回值
     * 再将一个字符串的第二个和第四个索引位置进行截取子串
     */
    interface Function {
        /**
         * 见名知意
         *
         * @param string 入参
         * @return /
         */
        String getValue(String string);
    }

    /**
     * 练习3
     * 声明一个带两个泛型接口的函数式接口，泛型类型为<T,R> T为参数，R为返回值;
     * 在TestLambda类中声明方法，使用接口作为参数，计算两个long类型参数的和。再计算两个long类型参数的乘积
     *
     * @param <T>
     * @param <R>
     */
    interface GenericsInterface<T, R> {

        /**
         *  处理两个类型
         * @param t1 /
         * @param t2 /
         * @return /
         */
        R test(T t1, T t2);

    }

    static class TestLambda {
        static String alterString(String s, Function function) {
            return function.getValue(s);
        }

        static Integer calculate(Double l1,Double l2, GenericsInterface<Double, Integer> genericsInterface){
            return genericsInterface.test(l1, l2);
        }
    }


}
