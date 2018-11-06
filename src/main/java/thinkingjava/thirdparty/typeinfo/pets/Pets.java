package thinkingjava.thirdparty.typeinfo.pets;

import java.util.*;

/**
 * Facade to produce a default PetCreator.
 *
 * @author 李重辰
 * @date 2018/11/6 20:01
 */
public class Pets {
  public static final AbstractPetCreator CREATOR =
      new LiteralPetCreator();

  public static Pet randomPet() {
    return CREATOR.randomPet();
  }

  public static Pet[] createArray(int size) {
    return CREATOR.createArray(size);
  }

  public static ArrayList<Pet> arrayList(int size) {
    return CREATOR.arrayList(size);
  }
}
