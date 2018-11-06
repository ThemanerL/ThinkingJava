package thinkingjava.thirdparty.typeinfo.pets;

import java.util.*;

/**
 * Creates random sequences of Pets.
 *
 * @author 李重辰
 * @date 2018/11/6 20:01
 */
public abstract class AbstractPetCreator {
  int seed = 47;
  private Random rand = new Random(seed);

  /**
   * The List of the different types of Pet to create:
   *
   * @return 一个list
   */
  public abstract List<Class<? extends Pet>> types();

  public Pet randomPet() { // Create one random Pet
    int n = rand.nextInt(types().size());
    try {
      return types().get(n).newInstance();
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  public Pet[] createArray(int size) {
    Pet[] result = new Pet[size];
    for (int i = 0; i < size; i++) {
      result[i] = randomPet();
    }
    return result;
  }

  public ArrayList<Pet> arrayList(int size) {
    ArrayList<Pet> result = new ArrayList<Pet>();
    Collections.addAll(result, createArray(size));
    return result;
  }
}
