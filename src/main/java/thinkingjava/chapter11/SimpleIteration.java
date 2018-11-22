package thinkingjava.chapter11;

import thinkingjava.thirdparty.typeinfo.pets.Pet;
import thinkingjava.thirdparty.typeinfo.pets.Pets;

import java.util.Iterator;
import java.util.List;

/**
 * @author 李重辰
 * @date 2018/11/8 19:58
 */
public class SimpleIteration {
  public static void main(String[] args) {
    List<Pet> pets = Pets.arrayList(12);
    Iterator<Pet> petIterator = pets.iterator();
    while (petIterator.hasNext()){
      Pet p = petIterator.next();
      System.out.println(p.id() + ":" + p + " ");
    }
    System.out.println();
    for (Pet p: pets) {
      System.out.println(p.id() + ":" + p +" ");
    }
    System.out.println();

    petIterator = pets.iterator();
    int size = 6;
    for (int i = 0; i < size; i++) {
      petIterator.next();
      System.out.println( petIterator.next());
      petIterator.remove();
    }
    System.out.println(pets);
  }
}
