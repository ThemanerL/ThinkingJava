package thinkingjava.chapter09;

/**
 * @author 李重辰
 * @date 2018/10/16 20:05
 */
public class NestingInterfaces {
    public class BImp implements A.B {
        public void f() { }
    }

    class CImp implements A.C {
        public void f() { }
    }

//    /**
//     * 除了该接口的定义类之外，不能实现私有接口
//     */
//    class DImp implements A.D{
//        public void f(){};
//    }

    class EImp implements E {
        public void g(){ }
    }

    class EGImp implements E.G{
        public void f(){ }
    }

    class EImp2 implements E {
        public void g(){ }
        class EG implements E.G {
            public void f(){ }
        }
    }

    public static void main(String[] args) {
        A a = new A();
///     A.D ad = a.getD(); thinkingjava.chapter09.A.D' has private access in 'thinkingjava.chapter09.A'
        // 可以通过这种方式newDImp2的对象，但是不能向上转为接口D，因为D是私有的。
        A.DImp2 d2 = a.new A.DImp2();

///     A.DImp2 di2 = a.getD(); 这里出错是因为getD()返回的类型是接口D的。而Dimp2不能说是实现了D接口
///     a.getD().f();  D是私有的

        ///这是因为只在类的内部调用私有的接口D，也就是讲返回值交给有权使用它的对象
        A a2 = new A();
        a2.receiveD(a.getD());
    }

}

class A {
    interface B {
        void f();
    }

    public class BImp implements B {
        public void f() {
        }
    }

    public class BImp2 implements B {
        public void f() {
        }
    }

    public interface C {
        void f();
    }

    class CImp implements C {
        public void f() {
        }
    }

    private class CImp2 implements C {
        public void f() {
        }
    }

    private interface D {
        void f();
    }

    private class DImp implements D {
        public void f() {
        }
    }

    /**
     * 返回对private接口引用的public方法。
     * A.DImp2只能被其自身所使用，你无法说它实现了一个private接口D
     * 实现是个private接口只是一种方式，可以强制该接口中的方法定义不要添加任何类型信息（即，不允许向上转型）。
     */
    public class DImp2 implements D {
        public void f() {
        }
    }

    public D getD() {
        return new DImp2();
    }

    private D dRef;

    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }
}

/**
 * 接口中的所有元素都必须是public的，所以这里提示public定义冗余
 */
interface E {
    interface G {
        void f();
    }

    /**
     * Redundant "public"
     */
    public interface H {
        void f();
    }

    void g();
    /// 接口中不能定义私有
    //private interface I{}
}