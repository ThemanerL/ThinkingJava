package thinkingjava.typeinfo.practice;

/**
 * 判断char数据究竟是个基本类型还是个对象
 *
 * @author 李重辰
 * @date 2019/12/15 16:58
 */
public class P10 {
  public static void main(String[] args) {
    char[] chars = {'a','v','w','d'};
    new P10().judge(chars);
  }

  private void judge (Object o) {
    System.out.println(o.getClass().getName());
  }
}
