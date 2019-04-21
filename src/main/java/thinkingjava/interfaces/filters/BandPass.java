package thinkingjava.interfaces.filters;

/**
 * @author 李重辰
 * @date 2018/10/10 21:57
 */
public class BandPass extends Filter {
  double lowCutoff, highCutoff;

  public BandPass(double lowCutoff, double highCutoff) {
    lowCutoff = lowCutoff;
    highCutoff = highCutoff;
  }

  @Override
  public WaveForm process(WaveForm input) {
    return input;
  }
}
