package thinkingjava.string;

import java.util.Scanner;

/**
 * @author 李重辰
 * @date 2019/12/9 21:06
 */
public class BetterRead {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(SimpleRead.input);
    System.out.println("What is your name?");
    String name = scanner.nextLine();
    System.out.println(name);
    System.out.println("How old are you? What is you favorite double?");
    System.out.println("(input:<age> <double>)");
    int age = scanner.nextInt();
    double favorite = scanner.nextDouble();
    System.out.println(age);
    System.out.println(favorite);
    System.out.format("Hi %s.\n", name);
    System.out.format("In 5 years you will be %d.\n", age + 5);
    System.out.printf("My favorite double is %f.", favorite / 2);
  }
}
