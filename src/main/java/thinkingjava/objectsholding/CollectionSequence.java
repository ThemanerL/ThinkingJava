package thinkingjava.objectsholding;

import thinkingjava.thirdparty.typeinfo.pets.Pet;
import thinkingjava.thirdparty.typeinfo.pets.Pets;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * 此处的警告信息在泛型解决
 * @author 李重辰
 * @date 2018/11/20 10:09
 */
public class CollectionSequence <T> extends AbstractCollection {
  private Pet[] pets = Pets.createArray(8);

  @Override
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

  @Override
  public int size() {
    return pets.length;
  }

  public static void main(String[] args) {
    CollectionSequence<Pet> sequence = new CollectionSequence<>();
    InterfaceVsIterator.display(sequence);
    InterfaceVsIterator.display(sequence.iterator());
  }
}
