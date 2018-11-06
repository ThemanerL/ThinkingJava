package thinkingjava.thirdparty.typeinfo.pets;

import java.util.*;

/**
 * Using class literals.
 *
 * @author 李重辰
 * @date 2018/11/6 20:01
 */
public class LiteralPetCreator extends AbstractPetCreator {
  /**
   * No try block needed.
   */
  @SuppressWarnings("unchecked")
  public static final List<Class<? extends Pet>> ALL_TYPES =
      Collections.unmodifiableList(Arrays.asList(
          Pet.class, Dog.class, Cat.class, Rodent.class,
          Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
          Cymric.class, Rat.class, Mouse.class, Hamster.class));
  /**
   * Types for random creation:
   */
  private static final List<Class<? extends Pet>> TYPES =
      ALL_TYPES.subList(ALL_TYPES.indexOf(Mutt.class),
          ALL_TYPES.size());

  @Override
  public List<Class<? extends Pet>> types() {
    return TYPES;
  }

  public static void main(String[] args) {
    System.out.println(TYPES);
  }
} /* Output:
[class Mutt, class Pug, class EgyptianMau, class Manx, class Cymric, class Rat, class Mouse, class Hamster]
*///:~
