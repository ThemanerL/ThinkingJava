package jdk8characteristic;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Stream的三个操作步骤
 * 1. 创建Stream
 * 2. 中间操作
 * 3. 终止操作
 *
 * @author 李重辰
 * @date 2019/5/16 23:24
 */
public class StreamTest {

  @Test
  public void createStream() {
    // 可以通过Collection系列集合提供的Stream()(串行流)或parallelStream()(并行流)
    Stream<Employee> stream = Employee.employees.stream();
    // 通过Arrays中的静态方法Stream获得数组流
    Employee[] emps = Employee.employees.toArray(new Employee[0]);
    Stream<Employee> stream1 = Arrays.stream(emps);
    // 通过Stream类中的静态方法of()
    Stream<String> stream2 = Stream.of("a", "b", "c");
    // 创建无限流:迭代
    Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);
    stream3.limit(10).forEach(System.out::println);
    // 创建无限流:生成
    Stream.generate(() -> new Random().nextInt()).limit(17).forEach(System.out::println);
  }

}
