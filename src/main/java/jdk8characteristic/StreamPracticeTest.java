package jdk8characteristic;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 李重辰
 * @date 2019/5/18 22:39
 */
public class StreamPracticeTest {
  /**
   * 给定一个数字列表，返回一个由每个数的平方组成的列表
   */
  @Test
  public void practice1() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    list.stream().map((x) -> x * x).collect(Collectors.toList()).forEach(System.out::println);
  }

  /**
   * 用map和reduce计算流中一共有多少某个对象
   */
  @Test
  public void practice2() {
    Integer integer = Employee.employees.stream().map(e -> 1).reduce(0, Integer::sum);
    System.out.println(integer);
  }
}
