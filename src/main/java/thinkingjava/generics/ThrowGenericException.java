package thinkingjava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 由于擦除的原因，将泛型应用异常是非常受限的。catch语句不能捕获泛型类型的异常，因为在编译器和运行时都必须知道异常的确切类型。
 * 泛型类也不能直接或间接继承自Throwable（这将进一步阻止你去定义不能捕获的异常）。
 * 但是，类型参数可能会在一个方法的throws子句中用到。这使得你可以编写随检查型异常的类型而发生变化的泛型代码
 *
 * @author 李重辰
 * @date 2020/6/28 10:02
 */
public class ThrowGenericException {
  public static void main(String[] args) {
    testFailure1();
    testFailure2();
  }

  private static void testFailure1() {
    ProcessRunner<String, Failure1> runner = new ProcessRunner<>();
    for (int i = 0; i < 3; i++) {
      runner.add(new Processor1());
    }
    try {
      System.out.println(runner.processAll());
    } catch (Failure1 failure1) {
      failure1.printStackTrace();
    }
  }

  private static void testFailure2() {
    ProcessRunner<Integer, Failure2> runner2 = new ProcessRunner<>();
    for (int i = 0; i < 3; i++) {
      runner2.add(new Processor2());
    }
    try {
      System.out.println(runner2.processAll());
    } catch (Failure2 failure2) {
      failure2.printStackTrace();
    }
  }
}

interface Processor<T, E extends Exception> {
  void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {

  private static final long serialVersionUID = -2612088326016803396L;

  List<T> processAll() throws E {
    List<T> resultCollector = new ArrayList<>();
    for (Processor<T, E> processor : this) {
      processor.process(resultCollector);
    }
    return resultCollector;
  }

}

class Failure1 extends Exception {
  private static final long serialVersionUID = 8716662044580144324L;
}

class Processor1 implements Processor<String, Failure1> {
  static int count = 3;

  @Override
  public void process(List<String> resultCollector) throws Failure1 {
    if (count-- > 1) {
      resultCollector.add("Hep！");
    } else {
      resultCollector.add("Ho!");
    }
    if (count < 0) {
      throw new Failure1();
    }
  }
}

class Failure2 extends Exception {
  private static final long serialVersionUID = 95621053902084643L;
}

class Processor2 implements Processor<Integer, Failure2> {
  static int count = 2;

  @Override
  public void process(List<Integer> resultCollector) throws Failure2 {
    if (count-- == 0) {
      resultCollector.add(47);
    } else {
      resultCollector.add(11);
    }
    if (count < 0) {
      throw new Failure2();
    }
  }
}
