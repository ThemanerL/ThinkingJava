package thinkingjava.chapter09.filters;

/**
 * Filter 于Processor具有相同的接口元素，但是因为它并非继承自Processor因为Filter类的创建者压根不清楚你想要将它用作Processor
 * 因此你不能将Filter用于Apply.process()方法，即便这样做可以正常运行。这里主要是因为Apply.process()方法的Process之间的耦合过紧，
 * 已经超过了所需要的程度，这就使得应该复用Apply.process()的代码时，复用却被禁止了。另外还需要注意的是它们的输入和输出都是Waveform
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
