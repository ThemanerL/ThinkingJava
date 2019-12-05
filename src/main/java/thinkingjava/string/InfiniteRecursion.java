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
    /// 此处字符串后面有一个加号，而在字符串后面紧跟的不是String，所以会调用this.toString()来将this转化为String，所以会发生递归调用。
    // return " InfiniteRecursion address: " + this + "\n";
    return " InfiniteRecursion address: " + super.toString() + "\n";
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
