package thinkingjava.typeinfo;

import thinkingjava.typeinfo.pets.*;

import java.util.HashMap;

/**
 * @author 李重辰
 * @date 2019/12/18 20:30
 */
public class PetCount {

  static class PetCounter extends HashMap<String, Integer> {
    public void count(String type) {
      merge(type, 1, Integer::sum);
    }
  }

  public static void countPets(AbstractPetCreator create) {
    PetCounter counter = new PetCounter();
    for (Pet pet : create.createArray(20)) {
      System.out.println(pet.getClass().getSimpleName() + " ");
      counter.count("Pet");
      if (pet instanceof Dog) {
        counter.count("Dog");
      }
      if (pet instanceof Mutt) {
        counter.count("Mutt");
      }
      if (pet instanceof Pug) {
        counter.count("Pug");
      }
      if (pet instanceof Cat) {
        counter.count("Cat");
      }
      if (pet instanceof EgyptianMau) {
        counter.count("EgyptianMau");
      }
      if (pet instanceof Manx) {
        counter.count("Manx");
      }
      if (pet instanceof Cymric) {
        counter.count("Cymric");
      }
      if (pet instanceof Rodent) {
        counter.count("Pet");
      }
      if (pet instanceof Rat) {
        counter.count("Pet");
      }
      if (pet instanceof Mouse) {
        counter.count("Pet");
      }
      if (pet instanceof Hamster) {
        counter.count("Pet");
      }
      if (pet instanceof Gerbil) {
        counter.count("Gerbil");
      }
    }
    System.out.println();
    System.out.println(counter);
  }

  public static void main(String[] args) {
    countPets(new ForNameCreator());
  }
}
