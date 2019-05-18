package thinkingjava.innerclasses;

interface Counter {
  /**
   * 接口中的方法必须使用javadoc注释
   *
   * @return 返回下一个
   */
  int next();
}

/**
 * 局部内部类的名字在方法外也是不可见的。但是我们为什么还要用局部内部类而不用匿名类，是因为局部内部类可以给构造器命名，
 * 可以重载构造器，而匿名内部类只能用于实例初始化
 *
 * @author 李重辰
 * @date 2018/11/2 16:27
 */
public class LocalInnerClass {
  private int count = 0;

  public static void main(String[] args) {
    LocalInnerClass localInnerClass = new LocalInnerClass();
    Counter counter1 = localInnerClass.getCounter("类一");
    Counter counter12 = localInnerClass.getCounter2("类二");
    int j = 5;
    for (int i = 0; i < j; i++) {
      System.out.println(counter1.next());
    }
    for (int i = 0; i < j; i++) {
      System.out.println(counter12.next());
    }
  }

  private Counter getCounter(final String name) {
    class LocalCounter implements Counter {
      private LocalCounter() {
        System.out.println("LocalCounter()");
      }

      @Override
      public int next() {
        System.out.println(name);
        return ++count;
      }
    }

    return new LocalCounter();
  }

  private Counter getCounter2(final String name) {
    return new Counter() {
      // 匿名内部类并不能有带有名字而构造器，只能使用构造代码块替代
      {
        System.out.println("Counter()");
      }

      @Override
      public int next() {
        System.out.print(name);
        return ++count;
      }
    };
  }
}