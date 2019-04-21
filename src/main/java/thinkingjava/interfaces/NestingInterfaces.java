package thinkingjava.interfaces;

/**
 * @author 李重辰
 * @date 2018/10/16 20:05
 */
public class NestingInterfaces {
  public class Bimpl implements Aclass.Bable {
    @Override
    public void f() {
    }
  }

  class Cimpl implements Aclass.Cable {
    @Override
    public void f() {
    }
  }

//    /**
//     * 除了该接口的定义类之外，不能实现私有接口
//     */
//    class Dimpl implements Aclass.Dable{
//        public void f(){};
//    }

  class Eimpl implements Eable {
    @Override
    public void g() {
    }
  }

  class EimplGimpl implements Eable.Gable {
    @Override
    public void f() {
    }
  }

  class Eimpl2 implements Eable {
    @Override
    public void g() {
    }

    class EableGable implements Eable.Gable {
      @Override
      public void f() {
      }
    }
  }

  public static void main(String[] args) {
    Aclass a = new Aclass();
///     Aclass.Dable ad = a.getDable(); thinkingjava.interfaces.Aclass.Dable' has private access in 'thinkingjava.interfaces.Aclass'
    // 可以通过这两种方式newDimpl2的对象，但是不能向上转为接口Dable，因为Dable是私有的。
    Aclass.Dimpl2 d2 = a.new Dimpl2();
    Aclass.Dimpl2 d3 = new Aclass().new Dimpl2();

///     Aclass.Dimpl2 di2 = a.getDable(); 这里出错是因为getDable()返回的类型是接口Dable的。而Dableimp2不能说是实现了Dable接口
///     a.getDable().f();  Dable是私有的

    ///这是因为只在类的内部调用私有的接口Dable，也就是讲返回值交给有权使用它的对象
    Aclass a2 = new Aclass();
    a2.receiveDable(a.getDable());
  }

}

class Aclass {
  interface Bable {
    /**
     * 抽象方法必须用javadoc注释
     */
    void f();
  }

  public class Bimpl implements Bable {
    @Override
    public void f() {
    }
  }

  public class Bimpl2 implements Bable {
    @Override
    public void f() {
    }
  }

  public interface Cable {
    /**
     * 抽象方法必须用javadoc注释
     */
    void f();
  }

  class Cimpl implements Cable {
    @Override
    public void f() {
    }
  }

  private class Cimpl2 implements Cable {
    @Override
    public void f() {
    }
  }

  private interface Dable {
    /**
     * 抽象方法必须用javadoc注释
     */
    void f();
  }

  private class Dimpl implements Dable {
    @Override
    public void f() {
    }
  }

  /**
   * 返回对private接口引用的public方法。
   * Aclass.Dimpl2只能被其自身所使用，你无法说它实现了一个private接口Dable
   * 实现是个private接口只是一种方式，可以强制该接口中的方法定义不要添加任何类型信息（即，不允许向上转型）。
   */
  public class Dimpl2 implements Dable {
    @Override
    public void f() {
    }
  }

  public Dable getDable() {
    return new Dimpl2();
  }

  private Dable dRef;

  public void receiveDable(Dable d) {
    dRef = d;
    dRef.f();
  }
}

/**
 * 接口中的所有元素都必须是public的，所以这里提示public定义冗余
 */
interface Eable {
  interface Gable {
    /**
     * 抽象方法必须用javadoc注释
     */
    void f();
  }

  /**
   * Redundant "public"
   */
  public interface Hable {
    /**
     * 抽象方法必须用javadoc注释
     */
    void f();
  }

  /**
   * 抽象方法必须用javadoc注释
   */
  void g();
  /// 接口中不能定义私有
  //private interface I{}
}