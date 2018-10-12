package thinkingjava.chapter09;

/**
 * @author 李重辰
 * @date 2018/10/12 12:34
 */
public class InterfaceCollision {
}

interface I1 {
    /**
     * 接口内的方法必须要有javadoc声明
     */
    void f();
}

interface I2{
    /**
     * 接口内的方法必须要有javadoc声明
     */
    int f (int i);
}

interface I3{
    /**
     * 接口内的方法必须要有javadoc声明
     */
    int f();
}

class C1{
    public int f(){
        return 1;
    }
}

class C2 implements I1,I2{
    public void f() {

    }

    public int f(int i) {
        return 1;
    }
}

class C3 extends C1 implements I2{
    public int f(int i) {
        return 1;
    }
}

class C4 extends C1 implements I3{
    @Override
    public int f() {
        return 1;
    }
}