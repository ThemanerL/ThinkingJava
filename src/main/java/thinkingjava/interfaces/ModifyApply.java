package thinkingjava.interfaces;

interface ModifyProcessor {
  /**
   * 接口的方法必须使用javac注释
   *
   * @return 暂时还没具体实现
   */
  String name();

  /**
   * 接口的方法必须使用javac注释
   *
   * @param input 输入一个对象
   * @return 暂时还没具体实现
   */
  Object process(Object input);
}

/**
 * @author 李重辰
 * @date 2018/10/11 11:10
 */
public class ModifyApply {
  public static void process(ModifyProcessor p, Object s) {
    System.out.println("Using Processor " + p.name());
    System.out.println(p.process(s));
  }
}
