package thinkingjava.typeinfo.toys;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

/**
 * @author 李重辰
 * @date 2019/12/14 10:32
 */
public class ToyTest {
  private static void printInfo(Class cc) {
    System.out.println("Class Name:" + cc.getName() + " is interface? [" + cc.isInterface() + "]");
    System.out.println("Simple Name:" + cc.getSimpleName());
    System.out.println("Canonical name:" + cc.getCanonicalName());
  }

  public static void main(String[] args) {
    Class cc = null;
    try {
      cc = Class.forName("thinkingjava.typeinfo.toys.FancyToy");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      System.exit(1);
    }
    printInfo(cc);
    for (Class face : cc.getInterfaces()) {
      printInfo(face);
    }
    Class up = cc.getSuperclass();
    Object obj = null;
    try {
      obj = up.newInstance();
    } catch (IllegalAccessException | InstantiationException e) {
      e.printStackTrace();
      System.exit(1);
    }
    printInfo(obj.getClass());
    System.out.println("------------------------------");
    ToyTest test = new ToyTest();
    test.p19(5);
  }

  private void p19(int i){
    try {
      Class<?> c = Class.forName("thinkingjava.typeinfo.toys.Toy");
      try {
        Constructor constructor = c.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        Object o = constructor.newInstance(i);
        printInfo(o.getClass());
      } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
        e.printStackTrace();
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}

class Toy {
  public Toy() {
  }

  Toy(int i) {
  }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots,Runnable {
  public FancyToy() {
    super(1);
  }

  @Override
  public void run() {

  }
}