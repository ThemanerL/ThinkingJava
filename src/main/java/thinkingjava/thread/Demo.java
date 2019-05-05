package thinkingjava.thread;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 李重辰
 * @date 2019/5/1 10:35
 */
public class Demo {
  public static void main(String[] args) {
    String a = "abc";
    String b = "xxx";
    Set<String> strings = new HashSet<>();
    for (int i = 0; i < a.length(); i++) {
      for (char c : a.toCharArray()) {
        for (char d : b.toCharArray()) {
          a = a.replace(c, d);
          strings.add(a);
        }
      }
    }
    boolean contains = strings.contains(b);
    System.out.println(contains);
  }
}

class FindError {
  public static void main(String[] args) {
    System.out.println(new FindError().find());
  }

  private int find() {
    int[] versions = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int left = 0;
    int right = versions.length - 1;
    while (true) {
      int mid = (left + right) / 2;
      if (isBug(versions[mid])) {
        // 目标版本号特征为，当前版本有错误，前一个版本无错误。
        if (!isBug(versions[mid-1])){
          return mid;
        }
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
  }

  private boolean isBug(int i){
    // 假设在版本2开始发生错误
    return i >= 2;
  }
}
