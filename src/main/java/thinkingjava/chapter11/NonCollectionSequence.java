package thinkingjava.chapter11;

import thinkingjava.thirdparty.typeinfo.pets.Pet;
import thinkingjava.thirdparty.typeinfo.pets.Pets;

import java.util.*;

/**
 * @author 李重辰
 * @date 2018/11/20 10:36
 */
public class NonCollectionSequence extends PetSequence{
  public Iterator<Pet> iterator() {
    return new Iterator<Pet>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        return index < pets.length;
      }

      @Override
      public Pet next() {
        return pets[index++];
      }
    };
  }

  private Iterable<Pet> reversed() {
    return () -> new Iterator<Pet>() {
      int index = pets.length - 1;

      @Override
      public boolean hasNext() {
        return index > -1;
      }

      @Override
      public Pet next() {
        return pets[index--];
      }
    };
  }

  private Iterable<Pet> randomized() {
    return () -> {
      List<Pet> pets = new ArrayList<>(Arrays.asList(super.pets));
      Collections.shuffle(pets);
      return pets.iterator();
    };
  }

  public static void main(String[] args) {
    NonCollectionSequence nonCollectionSequence = new NonCollectionSequence();
    InterfaceVsIterator.display(nonCollectionSequence.iterator());
    for (Pet pet : nonCollectionSequence.reversed()) {
      System.out.print(pet + " ");
    }
    System.out.println();
    for (Pet pet : nonCollectionSequence.randomized()) {
      System.out.print(pet + " ");
    }
  }
}

class PetSequence {
  protected Pet[] pets = Pets.createArray(8);
}