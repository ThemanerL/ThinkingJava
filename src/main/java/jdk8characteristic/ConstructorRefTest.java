package jdk8characteristic;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器使用
 * 格式--> ClassName::new
 * 数组引用
 *
 * @author 李重辰
 * @date 2019/5/15 22:51
 */
public class ConstructorRefTest {

  /**
   * 构造器引用
   */
  @Test
  public void test1() {
    Supplier<Employee> supplier = () -> new Employee();
    Supplier<Employee> supplier1 = Employee::new;
  }

  /**
   * 构造器引用
   */
  @Test
  public void test2() {
    Function<Integer, Employee> function = Employee::new;
    Employee employee = function.apply(321);
    System.out.println(employee);

    BiFunction<String, Integer, Employee> function1 = Employee::new;
    employee = function1.apply("sad得", 23);
    System.out.println(employee);
  }

  /**
   * 数组引用
   */
  @Test
  public void test3() {
    Function<Integer, String[]> function1 = (x) -> new String[x];
    String[] strings = function1.apply(2);
    System.out.println(strings.length);

    Function<Integer, Double[]> function = Double[]::new;
    Double[] doubles = function.apply(4);
    System.out.println(doubles.length);
  }
}
