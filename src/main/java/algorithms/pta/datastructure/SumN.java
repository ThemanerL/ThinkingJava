package algorithms.pta.datastructure;

/**
 * 递归的对 1 到 N 进行求和
 *
 * @author 李重辰
 * @date 2019/12/8 22:54
 */
public class SumN {
  private static int solution(int n) {
    if (n > 0) {
      int sum = solution(n - 1);
      return n + sum;
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(SumN.solution(100000));
  }
}
