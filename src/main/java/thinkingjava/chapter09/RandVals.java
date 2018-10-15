package thinkingjava.chapter09;

import java.util.Random;

/**
 * 同样的，这些值不是接口的一部分，它们的值被存储在该接口的静态存储区域。
 * @author 李重辰
 * @date 2018/10/15 18:04
 */
public interface RandVals {
    Random RAND = new Random(System.currentTimeMillis());
    int RANDOM_INT = RAND.nextInt(10);
    long RANDOM_LONG = RAND.nextLong() * 10;
    float RANDOM_FLOAT = RAND.nextFloat() * 10;
    double RANDOM_DOUBLE = RAND.nextDouble() * 10;
}
