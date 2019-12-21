package thinkingjava.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 注意，输出中包含一个public的默认构造器，即便能在代码中看到根本没有定义任何构造器。所看到的这个包含在列表中的构造器是编译器自动合成的。
 * 如果将ShowMethods作为一个非public的类（也就是拥有包访问权限），输出中就不会再显示出这个自动合成的默认构造器了。该自动合成的默认构造器
 * 会自动被赋予与类一样的访问权限。
 *
 * @author 李重辰
 * @date 2019/12/19 16:14
 */
class ShowMethods {
  private static Pattern p = Pattern.compile("(\\w+\\.)|(native)|(final)");

  public static void main(String[] args) {
    if (args.length < 1) {
      String usage = "usage:\n" +
          "ShowMethods qualified.class.name\n" +
          "To show all methods in class or:\n" +
          "ShowMethods qualified.class.name word\n" +
          "To search for methods involving ‘word’";
      System.out.println(usage);
      System.exit(0);
    }
    int lines = 0;
    try {
      Class<?> c = Class.forName(args[0]);
      Method[] methods = c.getMethods();
      // 使用Class.getConstructors()的方法只能获得到public的构造器
      Constructor[] constructors = c.getConstructors();
      if (args.length == 1) {
        for (Method method : methods) {
          System.out.println(p.matcher(method.toString()).replaceAll(""));
        }
        for (Constructor constructor : constructors) {
          System.out.println(p.matcher(constructor.toString()).replaceAll(""));
        }
        lines = methods.length + constructors.length;
      } else {
        for (Method method : methods) {
          if (method.toString().contains(args[1])) {
            System.out.println(p.matcher(method.toString()).replaceAll(""));
            lines++;
          }
        }
        for (Constructor constructor : constructors) {
          if (constructor.toString().contains(args[1])) {
            System.out.println(p.matcher(constructor.toString()).replaceAll(""));
            lines++;
          }
        }
      }
      System.out.println(lines);
    } catch (ClassNotFoundException e) {
      System.out.println("No such class: " + e);
    }
  }
}
