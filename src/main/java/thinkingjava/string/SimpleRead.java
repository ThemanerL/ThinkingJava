package thinkingjava.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author 李重辰
 * @date 2019/12/9 10:29
 */
public class SimpleRead {
  public static BufferedReader input = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61803"));

  public static void main(String[] args) {
    System.out.println("What's your name?");
    try {
      String name = input.readLine();
      System.out.println(name);
      System.out.println("How old are you? What is you favorite double?");
      System.out.println("(input:<age> <double>)");
      String numbers = input.readLine();
      System.out.println(numbers);
      String[] numArrays = numbers.split(" ");
      int age = Integer.parseInt(numArrays[0]);
      double favorite = Double.parseDouble(numArrays[1]);
      System.out.format("Hi %s.\n", name);
      System.out.format("In 5 years you will be %d.\n", age + 5);
      System.out.printf("My favorite double is %f.", favorite / 2);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
