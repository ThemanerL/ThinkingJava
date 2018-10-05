package thinkingjava.chapter08;

/**
 * 由于private方法被自动认为是final方法,而且对导出类是屏蔽的.因此,子类中的f()是一个全新的方法.
 * 父类中的该方法不能被重载.他们是同名的两个方法.因此重写的方法一定要加Override注解.在导出类中,
 * 对于基类的private方法,最好采用不同的名字.
 * @author 李重辰
 * @date 2018/10/3 0:59
 */
public class PrivateOverride {
    private void f(){
        System.out.println("PrivateOverride.f");
    }

    public static void main(String[] args) {
        PrivateOverride privateOverride = new Derived();
        privateOverride.f();
    }
}

class Derived extends PrivateOverride{
    public void f(){
        System.out.println("Derived.f");
    }
}
