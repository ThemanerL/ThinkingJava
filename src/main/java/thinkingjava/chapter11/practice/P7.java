package thinkingjava.chapter11.practice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 李重辰
 * @date 2018/11/8 18:29
 */
public class P7 {
  private int id;

  private P7(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "P7{" +
        "id=" + id +
        '}';
  }

  public static void main(String[] args) {
    P7[] p7s = new P7[10];
    int size = 10;
    for (int i = 0; i < size; i++) {
      p7s[i] = new P7(i);
    }
    ArrayList<P7> p7ArrayList = new ArrayList<>(Arrays.asList(p7s));
    p7ArrayList.removeAll(p7ArrayList.subList(1, 3));
    for (P7 p:p7ArrayList ) {
      System.out.println(p);
    }
  }

}
