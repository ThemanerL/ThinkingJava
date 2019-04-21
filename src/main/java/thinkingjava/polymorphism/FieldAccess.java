package thinkingjava.polymorphism;

/**
 * @author 李重辰
 * @date 2018/10/3 1:26
 */
public class FieldAccess {
  public static void main(String[] args) {
    Super sup = new Sub();
    System.out.println("sup.field = " + ((Sub) sup).field + ". sup.getField()" + sup.getField());
    Sub sub = new Sub();
    System.out.println("sub.field = " + sub.field + ". sub.getField()" + sub.getField()
        + ". sub.getSuperField() = " + sub.getSuperField());
  }
}

class Super {
  public int field = 0;

  public int getField() {
    return field;
  }
}

class Sub extends Super {
  public int field = 1;

  @Override
  public int getField() {
    return field;
  }

  public int getSuperField() {
    return super.getField();
  }
}