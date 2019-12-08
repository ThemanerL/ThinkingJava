package algorithms.pta.datastructure;

/**
 * 递归的输出 1 到 N
 *
 * @author 李重辰
 * @date 2019/12/8 22:54
 */
public class PrintN {
  private static void solution(int n) {
    if (n > 0) {
      solution(n - 1);
      System.out.println(n);
    }
  }

  public static void main(String[] args) {
    PrintN.solution(10);
  }
}
