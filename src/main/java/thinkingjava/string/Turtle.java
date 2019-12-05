package thinkingjava.string;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * @author 李重辰
 * @date 2019/12/5 10:43
 */
public class Turtle {

  private String name;
  private Formatter formatter;

  public Turtle(String name, Formatter formatter) {
    this.name = name;
    this.formatter = formatter;
  }

  public static void main(String[] args) {
    PrintStream printStream = System.out;
    Turtle tommy = new Turtle("Tommy", new Formatter(System.err));
    Turtle terry = new Turtle("Terry", new Formatter(printStream));
    tommy.move(0, 0);
    terry.move(7, 9);
    tommy.move(4, 8);
    terry.move(3, 2);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Formatter getFormatter() {
    return formatter;
  }

  public void setFormatter(Formatter formatter) {
    this.formatter = formatter;
  }

  public void move(int x, int y) {
    formatter.format("%s The Turtle is at (%d,%d)\n", name, x, y);
  }
}
