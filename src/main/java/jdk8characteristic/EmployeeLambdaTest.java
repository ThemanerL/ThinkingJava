package jdk8characteristic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据特性需求对Employee进行过滤;在需求多变的情况下，可以有多种方式来优化代码。
 *
 * 1. 委托设计模式
 *  解决需求多变的问题，这种情况下，需要按新的需求去筛选类的话，只需要新增实现类，而不需要改动原来的类。
 *  维护了开闭原则。
 * 2. 匿名内部类
 * 3. Lambda表达式简化匿名内部类代码
 * 4. Stream使用内置Predicate函数进一步简化代码
 * @author 李重辰
 * @date 2019/5/12 22:30
 */
public class EmployeeLambdaTest {
    private List<Employee> employees = Arrays.asList(
        new Employee("Tom",18,3000.1),
        new Employee("Joey",34,21000),
        new Employee("John",45,12000)
    );

    /**
     * 主测试类
     */
    @Test
    public void filterEmployee(){
        // 第一种方式
        System.out.println("----------1.1----------");
        List<Employee> empList = getResultByCondition(employees,new FilterByAge());
        empList.forEach(System.out::println);
        System.out.println("----------1.2----------");
        empList = getResultByCondition(employees,new FilterBySalary());
        empList.forEach(System.out::println);
        // 第二种方式
        System.out.println("----------2.1----------");
        empList = getResultByCondition(employees, new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge()<20;
            }
        });
        empList.forEach(System.out::println);
        // 第三种方式
        System.out.println("----------3.1----------");
        empList = getResultByCondition(employees, (e)->e.getAge()>18);
        empList.forEach(System.out::println);
        // 第四种方式
        System.out.println("----------4.1----------");
        empList.stream().filter((e)->e.getAge()>18).forEach(System.out::println);
    }

    private List<Employee> getResultByCondition(List<Employee> list, Predicate<Employee> ep){
        List<Employee> employees = new ArrayList<>();
        for (Employee e:list) {
            if (ep.test(e)){
                employees.add(e);
            }
        }
        return employees;
    }

}

interface Predicate<T>{
    /**
     * 返回条件筛选的结果
     * @param t /
     * @return /
     */
    boolean test(T t);
}

class FilterByAge implements Predicate<Employee> {
    @Override
    public boolean test(Employee o) {
        return o.getAge()>35;
    }
}
class FilterBySalary implements Predicate<Employee>{
    @Override
    public boolean test(Employee o) {
        return o.getSalary()>8000;
    }
}
