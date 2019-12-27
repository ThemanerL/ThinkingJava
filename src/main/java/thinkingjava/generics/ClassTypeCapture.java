package thinkingjava.generics;

/**
 * @author 李重辰
 * @date 2019/12/27 19:03
 */
public class ClassTypeCapture<T> {
  Class<T> kind;

  public ClassTypeCapture(Class<T> kind) {
    this.kind = kind;
  }

  public boolean f(Object arg) {
    return kind.isInstance(arg);
  }

  public static void main(String[] args) {
    ClassTypeCapture<Building> capture = new ClassTypeCapture<>(Building.class);
    System.out.println(capture.f(new Building()));
    System.out.println(capture.f(new House()));

    ClassTypeCapture<House> capture1 = new ClassTypeCapture<>(House.class);
    System.out.println(capture1.f(new Building()));
    System.out.println(capture1.f(new House()));
  }
}

class Building {
}

class House extends Building {
}