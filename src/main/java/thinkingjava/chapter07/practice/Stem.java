package thinkingjava.chapter07.practice;

/**
 * @author 李重辰
 * @date 2018/9/28 11:58
 */
public class Stem extends Root {
  Stem(int i) {
    super(i);
    System.out.println("Stem constructor" + i);
  }

  public static void main(String[] args) {
    Stem s = new Stem(3);
    try {
      //
    } finally {
      s.dispose();
    }
  }

  @Override
  void dispose() {
    System.out.println("Stem of dispose");
    super.dispose();
  }
}

class Root {
  Component1 c1;
  Component2 c2;
  Component3 c3;

  Root(int i) {
    c1 = new Component1(i);
    c2 = new Component2(i);
    c3 = new Component3(i);
    System.out.println("Root constructor" + (i + 1));
  }

  void dispose() {
    System.out.println("Root of dispose");
    c1.dispose();
    c2.dispose();
    c3.dispose();
  }
}

class Component1 {
  Component1(int i) {
    System.out.println("Component1 constructor");
  }

  void dispose() {
    System.out.println("Component1 of dispose");
  }
}

class Component2 {
  Component2(int i) {
    System.out.println("Component2 constructor");
  }

  void dispose() {
    System.out.println("Component2 of dispose");
  }
}

class Component3 {
  Component3(int i) {
    System.out.println("Component3 constructor");
  }

  void dispose() {
    System.out.println("Component3 of dispose");
  }
}