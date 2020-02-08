package thinkingjava.generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author 李重辰
 * @date 2020/1/7 19:54 
 */
public class NeedCasting {
  @SuppressWarnings("unchecked")
  public void f(String[] args) throws Exception {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
    List<Employee> shapes = (List<Employee>) in.readObject();
  }

  public static void main(String[] args) {

  }
}
