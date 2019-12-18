package thinkingjava.typeinfo;

import thinkingjava.net.mindview.util.TypeCounter;
import thinkingjava.typeinfo.pets.Pet;
import thinkingjava.typeinfo.pets.Pets;

/**
 * @author 李重辰
 * @date 2019/12/19 7:56
 */
public class PetCount4 {
  public static void main(String[] args) {
    TypeCounter counter = new TypeCounter(Pet.class);
    for (Pet pet : Pets.createArray(20)) {
      System.out.println(pet.getClass().getSimpleName() + " ");
      counter.count(pet);
    }
    System.out.println();
    System.out.println(counter);
  }
}
