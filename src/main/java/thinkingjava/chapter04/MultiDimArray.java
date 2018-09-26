package thinkingjava.chapter04;

import java.util.Random;

/**
 * @author 李重辰
 * @date 2018/9/26 10:56
 */
public class MultiDimArray {
    static Random rand = new Random();

    static int pRand(int mod) {
        return Math.abs(rand.nextInt()) % mod + 1;
    }

    public static void main(String[] args) {
        int[][] a1 = {
                {1, 2, 3,},
                {4, 5, 6,},
        };
    }
}
