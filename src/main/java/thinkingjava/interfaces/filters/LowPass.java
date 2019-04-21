package thinkingjava.interfaces.filters;

/**
 * @author 李重辰
 * @date 2018/10/10 21:19
 */
public class LowPass extends Filter {
  double cutoff;

  public LowPass(double cutoff) {
    this.cutoff = cutoff;
  }

  @Override
  public WaveForm process(WaveForm input) {
    return input;
  }
}
