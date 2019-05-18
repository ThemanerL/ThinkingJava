package thinkingjava.thirdparty.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李重辰
 * @date 2018/11/6 20:01
 */
public class ForNameCreator extends AbstractPetCreator {
  private static List<Class<? extends Pet>> types =
      new ArrayList<Class<? extends Pet>>();
  /**
   * Types that you want to be randomly created:
   */
  private static String[] typeNames = {
      "Mutt",
      "Pug",
      "EgyptianMau",
      "Manx",
      "Cymric",
      "Rat",
      "Mouse",
      "Hamster"
  };

  static {
    loader();
  }

  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for (String name : typeNames) {
        types.add(
            (Class<? extends Pet>) Class.forName(name));
      }
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Class<? extends Pet>> types() {
    return types;
  }
}
