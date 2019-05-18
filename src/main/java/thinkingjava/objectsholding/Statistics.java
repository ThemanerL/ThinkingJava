package thinkingjava.objectsholding;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 自动包装机制将随机生成的int转换为HashMap可以使用的Integer引用。
 *
 * @author 李重辰
 * @date 2018/11/13 21:44
 */
public class Statistics {
  public static void main(String[] args) {
    Random rand = new Random(System.currentTimeMillis());
    Map<Integer, Integer> map = new HashMap<>(16);
    int loop = 10000;
    for (int i = 0; i < loop; i++) {
      int r = rand.nextInt(20);
      Integer integer = map.get(r);
      map.put(r, integer == null ? 1 : integer + 1);
    }
    System.out.println(map);
  }
}
