package thinkingjava.chapter11;

import thinkingjava.thirdparty.typeinfo.pets.Pet;
import thinkingjava.thirdparty.typeinfo.pets.Pets;

import java.util.Iterator;

/**
 * @author 李重辰
 * @date 2018/11/20 10:36
 */
public class NonCollectionSequence extends PetSequence{
  public Iterator<Pet> iterator(){
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

  public static void main(String[] args) {
    NonCollectionSequence nonCollectionSequence = new NonCollectionSequence();
    InterfaceVsIterator.display(nonCollectionSequence.iterator());
  }
}

class PetSequence{
  protected Pet[] pets = Pets.createArray(8);
}