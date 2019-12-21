package thinkingjava.typeinfo.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 李重辰
 * @date 2019/12/18 20:54
 */
public class LiteralPerCreator extends AbstractPetCreator {

  @Override
  public List<Class<? extends Pet>> getTypes() {
    return TYPES;
  }

  public static List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(
      Arrays.asList(Pet.class, Dog.class, Cat.class, Rodent.class, Mutt.class, Pug.class,
          EgyptianMau.class, Manx.class, Cymric.class, Rat.class, Mouse.class, Hamster.class, Gerbil.class));

  public static final List<Class<? extends Pet>> TYPES = allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());

  public static void main(String[] args) {
    System.out.println(TYPES);
  }
}
