package thinkingjava.chapter10.practice;

/**
 * 示例10.6.1
 *
 * @author 李重辰
 * @date 2018/10/29 21:49
 */
public class MotifyFactories {

}

interface Service {
  /**
   * 接口中的方法必须使用javadoc注释
   */
  void method1();

  /**
   * 同上
   */
  void method2();
}

interface ServiceFactory {
  /**
   * 返回一个Service
   *
   * @return Service 实例
   */
  Service getService();
}

class ImplementationImpl implements Service {
  private ImplementationImpl() {
  }

  @Override
  public void method1() {
    System.out.println("Implementation1.method1");
  }

  @Override
  public void method2() {
    System.out.println("Implementation1.method2");
  }

  public static ServiceFactory factory = new ServiceFactory() {
    @Override
    public Service getService() {
      return new ImplementationImpl();
    }
  };
}