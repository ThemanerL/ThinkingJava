package jdk8characteristic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 函数式编程
 * JDK1.8 内置四大核心函数式接口
 * Consumer<T> 消费型接口
 *      void accept(T t);
 * Supplier<T> 供给型接口
 *      T get();
 * Function<T, R> 函数型接口 T代表参数类型，R为返回值类型
 *      R apply(T t);
 * Predicate<T> 断言型接口
 *      boolean test(T t);
 *
 * @author 李重辰
 * @date 2019/5/10 21:06
 */
public class FunctionProgramTest {

    @Test
    public void testConsumer(){
        happy(2.3,(x)-> System.out.println("花了"+x+"的钱"));
    }

    private void happy(Double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    @Test
    public void testSupplier(){
        getNumList(5,()-> new Random().nextInt(100)).forEach(System.out::println);

    }

    private List<Integer> getNumList(int num, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    @Test
    public void testFunction(){
        System.out.println(stringHandle("I still love you.", String::toUpperCase));
        System.out.println(stringHandle("I still love you.", (x)->x.replace("still","don't").replace("love","like").replace("."," and more.")));
    }

    private String stringHandle(String s, Function<String,String> function){
        return function.apply(s);
    }

    @Test
    public void testPredicate(){
        List<Integer> list = Arrays.asList(1,2,5,1,56,2,23,12,78,19);
        list = predicateInt(list,(x)-> x>15);
        list.forEach(System.out::println);

    }

    private List<Integer> predicateInt(List<Integer> list, Predicate<Integer> predicate){
        List<Integer> returnList = new ArrayList<>();
        for (Integer integer:list) {
            if (predicate.test(integer)){
                returnList.add(integer);
            }
        }
        return returnList;
    }

}


class MyStream<T> {
    private List<T> list;

    MyStream(List<T> list) {
        this.list = list;
    }

    void myForEach(ConsumerInterface<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
