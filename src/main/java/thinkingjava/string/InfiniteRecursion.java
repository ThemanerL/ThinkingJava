package thinkingjava.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李重辰
 * @date 2019/12/3 16:20
 */
public class InfiniteRecursion {

  @Override
  public String toString() {
    return " InfiniteRecursion address: " + this + "\n";
  }

  public static void main(String[] args) {
    int loops = 10;
    List<InfiniteRecursion> v = new ArrayList<>();
    for (int i = 0; i < loops; i++) {
      v.add(new InfiniteRecursion());
    }
    System.out.println(v);
  }
}
