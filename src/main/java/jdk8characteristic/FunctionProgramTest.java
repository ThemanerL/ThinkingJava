package jdk8characteristic;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
