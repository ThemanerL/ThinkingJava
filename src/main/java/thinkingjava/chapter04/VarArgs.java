package thinkingjava.chapter04;

/**
 * @author 李重辰
 * @date 2018/9/26 10:28
 */
public class VarArgs {
    static void f(Object[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }

    public static void main(String[] args) {
        f(new Object[]{
                new Integer(47), new VarArgs(),
                new Float(3.14), new Double(11.11)
        });
        f(new Object[]{
                "one", "two", "three"
        });
        f(new Object[]{
                new A(), new A(), new A()
        });
    }
}

@SuppressWarnings("ALL")
class A {
    int i;
}
