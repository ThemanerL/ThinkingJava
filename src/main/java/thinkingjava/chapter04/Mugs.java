package thinkingjava.chapter04;

/**
 * @author 李重辰
 * @date 2018/9/25
 */
public class Mugs {
    Mug c1;
    Mug c2;

    {
        c1 = new Mug(1);
        c2 = new Mug(2);
        System.out.println("c1 & c2 initialized");
    }

    Mugs() {
        System.out.println("Mugs()");
    }

    public static void main(String[] args) {
        System.out.println("Inside main()");
        Mugs x = new Mugs();
    }
}

class Mug {
    Mug(int marker) {
        System.out.println("Mug(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}
