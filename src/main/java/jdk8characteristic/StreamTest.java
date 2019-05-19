package jdk8characteristic;

import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
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

  private static Stream<Character> filterCharacter(String str) {
    List<Character> list = new ArrayList<>();
    for (Character c : str.toCharArray()) {
      list.add(c);
    }
    return list.stream();
  }

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

  /**
   * 筛选与切片
   * 惰性求值:中间操作不会执行任何操作，只有当你执行终止操作的时候，所有的中间操作一次执行。
   * 内部迭代：迭代操作由StreamAPI来完成。
   */
  @Test
  public void middleOperation() {
    Employee.employees.forEach(System.out::println);
    System.out.println("----------------");
    // filter/limit
    Employee.employees.stream()
        .filter((e) -> e.getAge() > 18)
        .limit(1)
        .forEach(System.out::println);
    System.out.println("----------------");
    // skip(n)跳过前n个元素
    Employee.employees.stream()
        .skip(3)
        .forEach(System.out::println);
    System.out.println("----------------");
    // distinct/通过hashCode和equals去重
    Employee.employees.stream()
        .distinct()
        .forEach(System.out::println);
    System.out.println("--------Map映射--------");
    // Map映射
    Employee.employees.stream()
        .map(Employee::getAge)
        .forEach(System.out::println);
    System.out.println("--------MapStream嵌套映射--------");
    Employee.employees.stream().map(Employee::getName)
        .map(StreamTest::filterCharacter)
        .forEach((stream) -> stream.forEach(System.out::print));
    System.out.println();
    Stream<Stream<Character>> stream = Employee.employees.stream()
        .map(Employee::getName)
        .map(StreamTest::filterCharacter);
    System.out.println("--------flatMapStream映射:将所有的流合并到一个流--------");
    Employee.employees.stream()
        .map(Employee::getName)
        .limit(5)
        .flatMap(StreamTest::filterCharacter)
        .forEach(System.out::print);
    System.out.println();
    /// 排序
    // sorted():自然排序
    // sorted(Comparator com):自定义排序
    System.out.println("--------sorted():自然排序--------");
    Employee.employees.stream()
        .map(Employee::getSalary)
        .sorted()
        .forEach(System.out::println);
    System.out.println("--------sorted(Comparator com):自定义排序--------");
    Employee.employees.stream()
        .sorted(Comparator.comparingInt(Employee::getAge))
        .forEach(System.out::println);
  }

  /**
   * 终止操作
   */
  @Test
  public void endOperation() {
    // 查找与匹配
    Assert.assertFalse(Employee.employees.stream()
        .allMatch((e) -> e.getStatus().equals(Employee.Status.Busy)));
    Assert.assertTrue(Employee.employees.stream()
        .anyMatch((e) -> e.getStatus().equals(Employee.Status.Busy)));
    Assert.assertFalse(Employee.employees.stream()
        .noneMatch((e) -> e.getStatus().equals(Employee.Status.Busy)));
    Optional<Employee> employee = Employee.employees.stream().findFirst();
    System.out.println(employee.isPresent());
    System.out.println(Employee.employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null));
    System.out.println(Employee.employees.stream().min(Comparator.comparingDouble(Employee::getSalary)).orElse(null));

    // Stream的规约:reduce
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    // 当返回值可能为空时，返回值类型为Optional
    Optional<Integer> reduce = list.stream().reduce(Integer::sum);
    System.out.println(reduce.orElse(0));
    // 当值不可能为空时，返回相应的值。
    Integer reduce2 = list.stream().reduce(0, Integer::sum);
    System.out.println(reduce2);
    Double aDouble = Employee.employees.stream().map(Employee::getSalary).reduce(0.0, Double::sum);
    System.out.println("每月需要发这么多工资" + aDouble);

    // 收集
    System.out.println("收集所有员工的名字");
    Employee.employees.stream().map(Employee::getName).collect(Collectors.toList()).forEach(System.out::print);
    System.out.println();
    Employee.employees.stream().map(Employee::getName).collect(Collectors.toSet()).forEach(System.out::print);
    System.out.println("每月需要发这么多工资");
    Double aDouble1 = Employee.employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getSum();
    System.out.println(aDouble1);
    // 分组收集
    Map<Employee.Status, List<Employee>> listMap = Employee.employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
    for (Map.Entry<Employee.Status, List<Employee>> statusListEntry : listMap.entrySet()) {
      System.out.println("K:" + statusListEntry.getKey() + " V:");
      for (Employee employee1 : statusListEntry.getValue()) {
        System.out.println(employee1);
      }
    }
    System.out.println("按状态分组计算工资");
    Iterator<Map.Entry<Employee.Status, List<Employee>>> iterator = listMap.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<Employee.Status, List<Employee>> entry = iterator.next();
      System.out.println("K:" + entry.getKey() + " v:" + entry.getValue().stream().mapToDouble(Employee::getSalary).sum());
    }
    // 分区收集
    Map<Boolean, List<Employee>> map = Employee.employees.stream().collect(Collectors.partitioningBy((e) -> e.getSalary() > 5000));
    Iterator<Map.Entry<Boolean, List<Employee>>> it1 = map.entrySet().iterator();
    System.out.println("按收入分区求总收入");
    while (it1.hasNext()) {
      Map.Entry<Boolean, List<Employee>> entry = it1.next();
      System.out.println("K:" + entry.getKey() + " V:" + entry.getValue().stream().map(Employee::getSalary).reduce(0.0, Double::sum));
    }
  }

  /**
   * 并行流，简化forkJoin
   */
  @Test
  public void parallelTest() {
    Instant instant = Instant.now();
    long sum = LongStream.rangeClosed(0, 10000000000L)
        .parallel().reduce(0, Long::sum);
    System.out.println("总和为" + sum + " ;总运行时间为" + Duration.between(instant, Instant.now()).toMillis());

    Instant instant1 = Instant.now();
    long sum1 = LongStream.rangeClosed(0, 10000000000L)
        .reduce(0, Long::sum);
    System.out.println("总和为" + sum1 + " ;总运行时间为" + Duration.between(instant1, Instant.now()).toMillis());
  }

}
