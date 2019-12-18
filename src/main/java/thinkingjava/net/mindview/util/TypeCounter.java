package thinkingjava.net.mindview.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李重辰
 * @date 2019/12/19 7:43
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {
  private Class<?> baseType;

  public TypeCounter(Class<?> baseType) {
    this.baseType = baseType;
  }

  public void count(Object obj) {
    Class<?> type = obj.getClass();
    if (!baseType.isAssignableFrom(type)) {
      throw new RuntimeException(obj + "应当是" + type + "或者" + type + "的子类");
    }
    countClass(type);
  }

  private void countClass(Class<?> type) {
    merge(type, 1, Integer::sum);
    Class<?> superClass = type.getSuperclass();
    if (superClass != null && baseType.isAssignableFrom(superClass)) {
      countClass(superClass);
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("{");
    for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
      result.append(pair.getKey().getSimpleName());
      result.append("=");
      result.append(pair.getValue());
      result.append("，");
    }
    result.delete(result.length() - 1, result.length());
    result.append("}");
    return result.toString();
  }
}
