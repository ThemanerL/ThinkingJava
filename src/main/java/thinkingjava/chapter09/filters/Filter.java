package thinkingjava.chapter09.filters;

/**
 * @author 李重辰
 * @date 2018/10/10 21:15
 */
public class Filter {
    public String name() {
        return getClass().getSimpleName();
    }

    public WaveForm process(WaveForm input) {
        return input;
    }
}
