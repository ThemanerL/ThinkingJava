package thinkingjava.typeinfo;

import thinkingjava.net.mindview.util.MapData;
import thinkingjava.typeinfo.pets.LiteralPerCreator;
import thinkingjava.typeinfo.pets.Pet;
import thinkingjava.typeinfo.pets.Pets;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 李重辰
 * @date 2019/12/19 6:59
 */
public class PetCount3 {
  public static void main(String[] args) {
    PetCounter petCounter = new PetCounter();
    for (Pet pet : Pets.createArray(20)) {
      System.out.println(pet.getClass().getSimpleName() + " ");
      petCounter.count(pet);
    }
    System.out.println();
    System.out.println(petCounter);
  }

  static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
    public PetCounter() {
      super(MapData.map(LiteralPerCreator.TYPES, 12));
    }

    public void count(Pet pet) {
      for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
        if (pair.getKey().isInstance(pet)) {
          put(pair.getKey(), pair.getValue() + 1);
        }
      }
    }

    @Override
    public String toString() {
      StringBuilder result = new StringBuilder("{");
      for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
        result.append(pair.getKey().getSimpleName());
        result.append("=");
        result.append(pair.getValue());
        result.append("，");
      }
      result.delete(result.length() - 2, result.length());
      result.append("}");
      return result.toString();
    }
  }
}
