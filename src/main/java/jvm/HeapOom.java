package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆内存溢出异常测试
 * vm Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author 李重辰
 * @date 2019/10/9 23:38
 */
public class HeapOom {
  public static void main(String[] args) {
    List<OomObject> list = new ArrayList<>();
    while (true) {
      list.add(new OomObject());
    }
  }

  static class OomObject {

  }
}
