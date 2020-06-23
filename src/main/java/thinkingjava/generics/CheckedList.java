package thinkingjava.generics;

import thinkingjava.typeinfo.pets.Cat;
import thinkingjava.typeinfo.pets.Dog;
import thinkingjava.typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 李重辰
 * @date 2020/6/23 23:00
 */
public class CheckedList {
  @SuppressWarnings("unchecked")
  static void oldStyleMethod(List probablyDogs) {
    probablyDogs.add(new Cat());
  }

  public static void main(String[] args) {
    List<Dog> dogList1 = new ArrayList<>();
    oldStyleMethod(dogList1);
    List<Dog> dogList2 = Collections.checkedList(new ArrayList<>(), Dog.class);
    try {
      oldStyleMethod(dogList2);
    } catch (Exception e) {
      System.out.println(e);
    }
    List<Pet> pets = Collections.checkedList(new ArrayList<>(), Pet.class);
    pets.add(new Dog());
    pets.add(new Cat());
  }
}
