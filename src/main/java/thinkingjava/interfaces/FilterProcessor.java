package thinkingjava.interfaces;

import thinkingjava.interfaces.filters.*;
import thinkingjava.interfaces.practice.P11;

/**
 * 这里方法ModifyApply.process方法原来的参数列表为(ModifyProcessor p, Object s)
 * 由于ModifyProcessor是一个接口，根据java的多态，结合父类引用指向子类对象。这里其实只要传入任意一个实现了该接口的类对象，
 * 如果是别的类没有实现该接口，也想要使用这个方法，可以通过适配器(这里的适配器指实现了该接口的类)进行包装，包装为实现了所
 * 需接口的类对象。以此完成对该方法的调用。
 * <p>
 * 我们现在传入一个实现了ModifyProcessor接口的对象，由于都实现了该接口，
 * 接口需要实现的方法该对象都进行了实现，所以对于接口来说，是一样的，但是我们可以在这个对象中做进一步的扩展。
 * 这就是“代理proxy”此处用到了代理。
 *
 * @author 李重辰
 * @date 2018/10/11 12:35
 */
public class FilterProcessor {
  public static void main(String[] args) {
    WaveForm w = new WaveForm();
    ModifyApply.process(new FilterAdapter(new LowPass(1.0)), w);
    ModifyApply.process(new FilterAdapter(new HighPass(2.0)), w);
    ModifyApply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);
    ModifyApply.process(new FilterAdapter(new P11()), w);
  }
}

/**
 * 在这种使用适配器的方式中，FilterAdapter的构造器接受你所拥有的接口Filter，然后生成具有你所需要的Processor接口的对象(此处为ModifyProcessor对象)。
 */
class FilterAdapter implements ModifyProcessor {
  private Filter filter;

  FilterAdapter(Filter filter) {
    this.filter = filter;
  }

  @Override
  public String name() {
    return filter.name();
  }

  @Override
  public WaveForm process(Object input) {
    return filter.process((WaveForm) input);
  }
}