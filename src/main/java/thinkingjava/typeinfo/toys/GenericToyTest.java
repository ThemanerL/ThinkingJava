package thinkingjava.typeinfo.toys;

/**
 * @author 李重辰
 * @date 2019/12/15 18:05
 */
public class GenericToyTest {
  public static void main(String[] args) throws IllegalAccessException, InstantiationException {
    Class<FancyToy> ftClass = FancyToy.class;
    FancyToy fancyToy = ftClass.newInstance();
    Class<? super FancyToy> up = ftClass.getSuperclass();
    /// 如果你手头的是超类，那编译器将只允许你声明超类引用是“某个类，它是FancyToy超类”，就像在表达式Class<? super FancyToy>
    // 中所看到的，而不会接受Class<Toy>这样的声明。这看上起有些怪，因为getSuperClass()方法返回的是基类（而不是接口），并且
    // 编译器在编译期就知道它是什么类型了——在本例中就是Toy.class——而不仅仅只是“某个类，它是FancyToy超类”。不管怎样，正是由于
    // 这种含糊性，up.newInstance()的返回值不是精确类型，而只是Object。
    // Class<Toy> up2 = ftClass.getSuperclass();
    Object obj = up.newInstance();
    System.out.println(obj.getClass().getName());
  }
}
