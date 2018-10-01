package thinkingjava.chapter05;

/**
 * @author 李重辰
 * @date 2018/10/1 11:49
 */
public class SimpleEunmUse {
    public static void main(String[] args) {
        Spiciness howHot = Spiciness.MEDIUM;
        System.out.println(howHot);
    }
}

class EnumOrder{
    public static void main(String[] args) {
        for (Spiciness s:Spiciness.values()){
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }
}
