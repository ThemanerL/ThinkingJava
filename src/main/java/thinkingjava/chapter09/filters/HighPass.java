package thinkingjava.chapter09.filters;

/**
 * @author 李重辰
 * @date 2018/10/10 21:21
 */
public class HighPass extends Filter {
    double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public WaveForm process(WaveForm input) {
        return input;
    }
}
