package thinkingjava.typeinfo.pets;


import java.util.ArrayList;

/**
 * @author 李重辰
 * @date 2019/12/18 21:09
 */
public class Pets {
  public static final AbstractPetCreator CREATOR = new LiteralPerCreator();

  public static Pet randomPet() {
    return CREATOR.randomPet();
  }

  public static Pet[] createArray(int size) {
    return CREATOR.createArray(size);
  }

  public static ArrayList<Pet> arrayList(int size) {
    return CREATOR.arraysList(size);
  }
}
