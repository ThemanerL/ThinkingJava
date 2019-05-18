package algorithms.pta.datastructure;

import java.util.Scanner;

/**
 * @author 李重辰
 * @date 2019/4/14 22:32
 */

public class LargestSubSequenceSum {
  private static int length;
  private int[] its;

  public static void main(String[] args) {
    LargestSubSequenceSum sum = new LargestSubSequenceSum();
    sum.dataIn();
    int i = sum.scannerData();
    System.out.println(i);
  }

  private void dataIn() {
    Scanner scanner = new Scanner(System.in);
    length = scanner.nextInt();
    its = new int[length];
    System.out.println();
    if (scanner.hasNext()) {
      for (int i = 0; i < length; i++) {
        its[i] = scanner.nextInt();
      }
    }
  }

  private int scannerData() {
    int tempSum = 0, sum = 0;
    for (int i = 0; i < length; i++) {
      tempSum += its[i];
      if (tempSum > sum) {
        sum = tempSum;
      } else if (tempSum < 0) {
        tempSum = 0;
      }
    }
    return sum;
  }

}
