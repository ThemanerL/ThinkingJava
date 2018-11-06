package thinkingjava.chapter07.practice;

import thinkingjava.chapter07.Orc;

/**
 * :练习7-15
 * 不能从此处调用Orc的protected方法,因为protected只允许子类或者同一个包中的类访问
 *
 * @author 李重辰
 * @date 2018/9/28 21:59
 */
public class OrcChild {
  public static void main(String[] args) {
    Orc o = new Orc("李重辰", 12);
    //o.printName
  }
}
