package thinkingjava.generics;

/**
 * @author 李重辰
 * @date 2020/1/10 17:19
 */
public class UseList<W,T> {
  /// 如下代码是不能编译的，由于擦除的原因，重新方法将产生相同的类型签名

//  void f1(List<T> b) {}
//  void f1(List<W> b) {}

//  void f(List<T> b) {}
//  void f(List<W> b) {}
}
