package jdk8characteristic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 测试学习1.8的Lambda表达式
 *
 * @author 李重辰
 * @date 2019/5/10 19:42
 */
public class LambdaTest {
  public static void main(String[] args) {
    final String goods = "goods", money = "money";
    ThreadPoolExecutor threadpool = new ThreadPoolExecutor(2, 2, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2), new ThreadPoolExecutor.DiscardOldestPolicy());
    threadpool.execute(() -> {
      synchronized (goods) {
        System.out.println(goods);
        try {
          Thread.sleep(300);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (money) {
          System.out.println(money);
        }
      }
    });

    threadpool.execute(() -> {
      synchronized (money) {
        System.out.println(money);
        try {
          Thread.sleep(700);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (goods) {
          System.out.println(goods);
        }
      }
    });
  }

  @Test
  public void firstLambda() {
    MyStream<String> stream = new MyStream<>(Arrays.asList("a", "b", "v", "d", "e", "f", "p"));
    // 原始代码
    stream.myForEach(new ConsumerInterface<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    });
    // 第一次简化
    stream.myForEach(x -> System.out.println(x));
    // 第二次简化
    stream.myForEach(System.out::println);

    ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3), new ThreadPoolExecutor.DiscardOldestPolicy());
    executor.execute(() -> System.out.println(stream));

  }

  /**
   * Collections.sort方法。
   */
  @Test
  public void lambdaTest1() {
    List<Integer> list = new ArrayList<>(Arrays.asList(344, 1, 23, 2, 3121, 2, 3, 4, 5, 5, 62));
    list.sort((s1, s2) -> s1.equals(s2) ? 0 : s1 - s2);
    list.forEach(System.out::println);
    list.forEach(s -> {
      if (s > Math.round(1.0)) {
        System.out.println(s);
      }
    });

    list.removeIf(s -> s > 3);
    list.forEach(System.out::println);
  }

  @Test
  public void convertTest() {
    List<String> collected = new ArrayList<>();
    collected.add("alpha");
    collected.add("beta");
    collected = collected.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
    System.out.println(collected);
  }
}
