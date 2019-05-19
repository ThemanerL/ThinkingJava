package jdk8characteristic;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author 李重辰
 * @date 2019/5/12 22:25
 */
public class Employee {
  static List<Employee> employees = Arrays.asList(
      new Employee("Tom", 18, 3000.1, Status.Single),
      new Employee("Joey", 34, 21000, Status.Busy),
      new Employee("Tom", 18, 3000.1, Status.Free),
      new Employee("Joey", 34, 25000, Status.Single),
      new Employee("John", 45, 12000, Status.Busy)
  );
  private String name;
  private int age;
  private double salary;
  private Status status;

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  Employee() {
  }

  Employee(int age) {
    this.age = age;
  }

  Employee(String name, int age) {
    this.name = name;
    this.age = age;
  }

  Employee(String name, int age, double salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  Employee(String name, int age, double salary, Status status) {
    this.name = name;
    this.age = age;
    this.salary = salary;
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public enum Status {
    /**
     * 忙
     */
    Busy("busy"),
    /**
     * 闲
     */
    Free("free"),
    /**
     * 单身狗
     */
    Single("Single");

    Status(String s) {
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Employee)) {
      return false;
    }
    Employee employee = (Employee) o;
    return getAge() == employee.getAge() &&
        Double.compare(employee.getSalary(), getSalary()) == 0 &&
        getName().equals(employee.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getAge(), getSalary());
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", salary=" + salary +
        ", status=" + status +
        '}';
  }
}
