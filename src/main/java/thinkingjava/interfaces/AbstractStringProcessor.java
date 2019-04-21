package thinkingjava.interfaces;

import java.util.Arrays;

/**
 * @author 李重辰
 * @date 2018/10/11 11:27
 */
public abstract class AbstractStringProcessor implements ModifyProcessor {

  @Override
  public String name() {
    return getClass().getSimpleName();
  }

  /**
   * 这个方法也是实现自ModifyProcessor
   *
   * @param input 输入一个对象
   * @return 返回一个对象的toString
   */
  @Override
  public abstract Object process(Object input);

  public static String s = "If she weighs the same as a duck, she's made of wood";

  public static void main(String[] args) {
    ModifyApply.process(new ModifyUpcase(), s);
    ModifyApply.process(new ModifyDowncase(), s);
    ModifyApply.process(new ModifySplitter(), s);
  }
}

class ModifyUpcase extends AbstractStringProcessor {
  @Override
  public Object process(Object input) {
    return ((String) input).toUpperCase();
  }
}

class ModifyDowncase extends AbstractStringProcessor {
  @Override
  public Object process(Object input) {
    return ((String) input).toLowerCase();
  }
}

class ModifySplitter extends AbstractStringProcessor {
  @Override
  public Object process(Object input) {
    return Arrays.toString(((String) input).split(" "));
  }
}

