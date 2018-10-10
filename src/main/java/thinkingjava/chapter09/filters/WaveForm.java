package thinkingjava.chapter09.filters;

/**
 * @author 李重辰
 * @date 2018/10/10 21:18
 */
public class WaveForm {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "WaveForm" + id;
    }
}
