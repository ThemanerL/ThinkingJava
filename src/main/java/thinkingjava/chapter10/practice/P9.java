package thinkingjava.chapter10.practice;

/**
 * @author 李重辰
 * @date 2018/10/22 20:07
 */
public class P9 {
    private P9interface getInstance (){
        class P9Inner implements P9interface{
            public void print() {
                System.out.println("P9Inner.print");
            }
        }
        return new P9Inner();
    }

    public static void main(String[] args) {
        P9 p9 = new P9();
        p9.getInstance().print();
    }
}

interface P9interface{
    /**
     * 接口中的类必须用javadoc注释
     */
    void print();
}
