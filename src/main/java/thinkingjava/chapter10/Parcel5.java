package thinkingjava.chapter10;

/**
 * 局部内部类
 * 在方法的作用域内创建一个完整的类。
 * @author 李重辰
 * @date 2018/10/22 18:28
 */
public class Parcel5 {
    private Destination destination(String s) {
        class P5Destination implements Destination {
            private String label;

            private P5Destination(String label) {
                this.label = label;
            }
            public String readLabel() {
                return label;
            }
        }
        return new P5Destination(s);
    }

    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        Destination destination = parcel5.destination("ThinkingJava");
        System.out.println(destination.readLabel());
    }
}
