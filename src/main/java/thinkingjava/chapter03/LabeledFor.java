package thinkingjava.chapter03;

/**
 * 这里注意 continue outer和break inner 的作用基本一致。
 *
 * @author 李重辰
 */
public class LabeledFor {
    public static void main(String[] args) {
        int i = 0;
        int iLength = 10;
        int kLength = 5;
        outer:
        for (; true; ) {
            inner:
            for (; i < iLength; i++) {
                System.out.println("i=" + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }
                if (i == 3) {
                    System.out.println("break");
                    i++;
                    break;
                }
                if (i == 7) {
                    System.out.println("continue outer");
                    i++;
                    continue outer;
                }
                if (i == 8) {
                    System.out.println("break outer");
                    break outer;
                }
                for (int k = 0; k < kLength; k++) {
                    if (k == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }
}
