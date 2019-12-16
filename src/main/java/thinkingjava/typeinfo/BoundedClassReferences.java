package thinkingjava.typeinfo;

/**
 * 向Class引用添加泛型语法的原因仅仅是为了提供编译期类型检查，因此如果你操作有误，稍后立即就会发现这一点。
 * 在使用普通Class引用，你不会误入歧途，但是如果你确实犯了错误，那么直到运行时你才会发现它，而这显示很不方便。
 *
 * @author 李重辰
 * @date 2019/12/15 17:51
 */
public class BoundedClassReferences {
  public static void main(String[] args) {
    Class<? extends Number> bounded = int.class;
    bounded = double.class;
    bounded = Number.class;
  }
}
