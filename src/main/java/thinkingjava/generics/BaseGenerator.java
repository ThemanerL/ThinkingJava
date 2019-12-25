package thinkingjava.generics;

import thinkingjava.net.mindview.util.Generator;

/**
 * @author 李重辰
 * @date 2019/12/25 19:12
 */
public class BaseGenerator<T> implements Generator<T> {
  private Class<T> type;

  public BaseGenerator(Class<T> type) {
    this.type = type;
  }

  @Override
  public T next(){
    try {
      return type.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static <T> Generator<T> create(Class<T> type){
    return new BaseGenerator<>(type);
  }
}
