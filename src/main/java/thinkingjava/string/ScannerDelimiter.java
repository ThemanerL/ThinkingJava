package thinkingjava.string;

import java.util.Scanner;

/**
 * @author 李重辰
 * @date 2019/12/12 22:22
 */
public class ScannerDelimiter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner("12, 23, 45, 12, 34, 89");
    scanner.useDelimiter("\\s*,\\s*");
    while (scanner.hasNextInt()) {
      System.out.println(scanner.nextInt());
    }
  }
}
