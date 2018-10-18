package thinkingjava.chapter09.factory;

/**
 * 遵循某个接口的对象的典型方式就是工厂方法设计模式。这与直接调用构造器不同，
 * 我们在工厂对象上调用的是创建方法，而该工厂对象将生成接口的某个实现的对象。
 * 理论上，通过这种方式，我们的代码将完全与接口的实现分离，这就使得我们可以
 * 透明地将某个实现替换为另一个实现。
 *
 * 如果不是用工厂方法，你的代码就必须在某处指定将要创建的Service的确切类型。
 * 以便调用合适的构造器。
 * @author 李重辰
 * @date 2018/10/18 12:19
 */
public class Factories {
    private static void serviceConsumer(ServiceFactory factory) {
        Service s = factory.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());
        serviceConsumer(new Implementation2Factory());
    }
}

interface Service {
    /**
     * 接口方法必须Javadoc注释
     */
    void method1();

    /**
     * 接口方法必须Javadoc注释
     */
    void method2();
}

interface ServiceFactory {
    /**
     * 接口方法必须Javadoc注释
     * @return 返回一个服务
     */
    Service getService();
}

class Implementation1Impl implements Service {
    Implementation1Impl() {
    }

    public void method1() {
        System.out.println("Implementation1.method1");
    }

    public void method2() {
        System.out.println("Implementation1.method2");
    }
}

class Implementation1Factory implements ServiceFactory{
    public Service getService() {
        return new Implementation1Impl();
    }
}

class Implementation2Impl implements Service {
    Implementation2Impl() {
    }

    public void method1() {

    }

    public void method2() {

    }
}

class Implementation2Factory implements ServiceFactory {
    public Service getService() {
        return new Implementation2Impl();
    }
}
