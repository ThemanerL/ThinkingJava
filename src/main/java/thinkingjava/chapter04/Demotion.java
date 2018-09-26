package thinkingjava.chapter04;

/**
 * 如果我们美哟是设置任何构造器，编译程序会说：“你看起来似乎需要一个构造器，所以让我们给你制造一个。”
 * 但假如我们写了一个构造器，编译器会说：“啊，你已写了一个构造器，所以我知道你想干什么，如果你放置一个默认的，是由于你打算省略它”
 *
 * @author 李重辰
 */
public class Demotion {
    static void prt(String s) {
        System.out.println(s);
    }

    void f1(char x) {
        prt("f1(char)");
    }

    void f1(byte x) {
        prt("f1(byte)");
    }

    void f1(short x) {
        prt("f1(short)");
    }

    void f1(int x) {
        prt("f1(int)");
    }

    void f1(long x) {
        prt("f1(long)");
    }

    void f1(float x) {
        prt("f1(float)");
    }

    void f1(double x) {
        prt("f1(double)");
    }

    void f2(char x) {
        prt("f2(char)");
    }

    void f2(byte x) {
        prt("f2(byte)");
    }

    void f2(short x) {
        prt("f2(short)");
    }

    void f2(int x) {
        prt("f2(int)");
    }

    void f2(long x) {
        prt("f2(long)");
    }

    void f2(float x) {
        prt("f2(float)");
    }

    void f3(char x) {
        prt("f3(char)");
    }

    void f3(byte x) {
        prt("f3(byte)");
    }

    void f3(short x) {
        prt("f3(short)");
    }

    void f3(int x) {
        prt("f3(int)");
    }

    void f3(long x) {
        prt("f3(long)");
    }

    void f4(char x) {
        prt("f4(char)");
    }

    void f4(byte x) {
        prt("f4(byte)");
    }

    void f4(short x) {
        prt("f4(short)");
    }

    void f4(int x) {
        prt("f4(int)");
    }

    void f5(char x) {
        prt("f5(char)");
    }

    void f5(byte x) {
        prt("f5(byte)");
    }

    void f5(short x) {
        prt("f5(short)");
    }

    void f6(char x) {
        prt("f6(char)");
    }

    void f6(byte x) {
        prt("f6(byte)");
    }

    void f7(char x) {
        prt("f7(char)");
    }

    void testDouble() {
        double x = 0;
        prt("double argument:");
        f1(x);
        f2((float) x);
        f3((long) x);
        f4((int) x);
        f5((short) x);
        f6((byte) x);
        f7((char) x);
    }

    public static void main(String[] args) {
        Demotion demotion = new Demotion();
        demotion.testDouble();
        //Bush bush = new Bush();
    }
}

class Bush {
    Bush(int i) {
    }

    Bush(double i) {
    }
}
