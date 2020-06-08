package rudiments.comparator;

import java.util.*;

/**
 * @author 李重辰
 * @date 2020/6/1 20:11
 */
public class Review {
  public static void main(String[] args) {
    List<GirlComparable> list = new ArrayList<>(100);
    GirlComparable girlComparable;
    for (int i = 0; i < 75; i++) {
      girlComparable = new GirlComparable("girl " + i, i);
      list.add(girlComparable);
    }
    Collections.shuffle(list);
    Collections.sort(list);
    list.forEach(System.out::println);

    Collections.shuffle(list);
    list.sort(new GirlComparator());
    list.forEach(System.out::println);
  }
}

class GirlComparable implements Comparable<GirlComparable> {

  private String name;
  private int age;

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

  public GirlComparable(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Girl [name=" + name + ", age=" + age + "]";
  }

  @Override
  public int compareTo(GirlComparable girl) {
    return this.age - girl.getAge();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GirlComparable that = (GirlComparable) o;
    return age == that.age &&
        Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }
}

class Girl {
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Girl girl = (Girl) o;

    if (age != girl.age) {
      return false;
    }
    return Objects.equals(name, girl.name);
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + age;
    return result;
  }

  private String name;
  private int age;

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

  public Girl(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Girl [name=" + name + ", age=" + age + "]";
  }

}

class GirlComparator implements Comparator<GirlComparable> {

  @Override
  public int compare(GirlComparable g1, GirlComparable g2) {
    return Integer.compare(g1.getAge(), g2.getAge());
  }

}