package thinkingjava.chapter11;

import thinkingjava.thirdparty.typeinfo.pets.Cat;
import thinkingjava.thirdparty.typeinfo.pets.Dog;
import thinkingjava.thirdparty.typeinfo.pets.Hamster;
import thinkingjava.thirdparty.typeinfo.pets.Pet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李重辰
 * @date 2018/11/13 21:51
 */
public class PetMap {
  public static void main(String[] args) {
    Map<String, Pet> petMap = new HashMap<>(16);
    petMap.put("My Cat", new Cat("Molly"));
    petMap.put("My Dog", new Dog("Ginger"));
    petMap.put("My Hamster", new Hamster("Boo"));
    System.out.println(petMap);
    Pet dog = petMap.get("My Dog");
    System.out.println(dog);
    System.out.println(petMap.containsKey("My Dog"));
    System.out.println(petMap.containsValue(dog));
  }
}
