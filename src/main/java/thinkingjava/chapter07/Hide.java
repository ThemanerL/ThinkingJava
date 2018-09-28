package thinkingjava.chapter07;

/**
 * 用与基础类完全一致的签名和返回类型来覆盖同名的方法，会使人迷惑。
 * @author 李重辰
 * @date 2018/9/27 20:37
 */
public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(new Milhouse());
    }
}

class Homer {
    char doh(char c) {
        System.out.println("doh(char)");
        return 'd';
    }

    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class Milhouse {
}

class Bart extends Homer {
    void doh(Milhouse m) {
    }
}
