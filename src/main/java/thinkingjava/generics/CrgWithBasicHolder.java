package thinkingjava.generics;

/**
 * 新类Subtype接受的参数和返回的值具有Subtype类型而不仅仅是BasicHolder类型，这是CRG的本质，基类用导出类代替其参数。
 *
 * @author 李重辰
 * @date 2020/6/22 20:17
 */
public class CrgWithBasicHolder {

  public static void main(String[] args) {
    Subtype subtype1 = new Subtype();
    Subtype subtype2 = new Subtype();
    subtype1.set(subtype2);
    Subtype subtype3 = subtype1.get();
    subtype1.f();
  }
}

class Subtype extends BasicHolder<Subtype> {

}