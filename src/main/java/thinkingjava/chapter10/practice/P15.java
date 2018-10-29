package thinkingjava.chapter10.practice;

/**
 * @author 李重辰
 * @date 2018/10/29 21:38
 */
public class P15 {
    public static void main(String[] args) {
        System.out.println(new PracticeTwo(){}.getInstance(15));
    }

}

class Practice15One{
    Practice15One(int i) {
    }
}

class PracticeTwo {
    Practice15One getInstance(int i) {
        return new Practice15One(i);
    }
}