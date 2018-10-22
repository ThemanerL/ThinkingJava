package thinkingjava.chapter10.practice;

/**
 * @author 李重辰
 * @date 2018/10/22 16:38
 */
public class P7 {
    private String name;

    private void printName () {
        System.out.println(name);
    }

    private Inner getInstance() {
        return new Inner();
    }

    class Inner{
        private int age = 18;

        void moidfyName(String nameModified){
            P7.this.name = nameModified;
            printName();
        }
    }

    public static void main(String[] args) {
        P7 p7 = new P7();
        p7.getInstance().moidfyName("李重辰");
        p7.getInstance().moidfyName("王大头");
        System.out.println(p7.getInstance().age);
    }
}
