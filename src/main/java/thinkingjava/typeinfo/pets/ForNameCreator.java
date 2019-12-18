package thinkingjava.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李重辰
 * @date 2019/12/18 19:28
 */
public class ForNameCreator extends AbstractPetCreator {

  private static List<Class<? extends Pet>> types = new ArrayList<>();

  private static String[] typeNames = {
      "thinkingjava.typeinfo.pets.Mutt",
      "thinkingjava.typeinfo.pets.Pug",
      "thinkingjava.typeinfo.pets.EgyptianMau",
      "thinkingjava.typeinfo.pets.Manx",
      "thinkingjava.typeinfo.pets.Cymric",
      "thinkingjava.typeinfo.pets.Rat",
      "thinkingjava.typeinfo.pets.Mouse",
      "thinkingjava.typeinfo.pets.Hamster",
  };

  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for (String name : typeNames) {
        types.add((Class<? extends Pet>) Class.forName(name));
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  static {
    loader();
  }

  @Override
  public List<Class<? extends Pet>> getTypes() {
    return types;
  }
}
