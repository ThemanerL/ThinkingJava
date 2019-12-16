package thinkingjava.typeinfo;

/**
 * @author 李重辰
 * @date 2019/12/15 17:40
 */
public class GenericClassReferences {
  public static void main(String[] args) {
    Class intClass = int.class;
    Class<?> genericIntClass = int.class;
    genericIntClass = intClass;
    intClass = double.class;
    genericIntClass = double.class;
  }
}
