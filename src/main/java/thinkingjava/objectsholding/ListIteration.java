package thinkingjava.objectsholding;

import thinkingjava.thirdparty.typeinfo.pets.Pet;
import thinkingjava.thirdparty.typeinfo.pets.Pets;

import java.util.List;
import java.util.ListIterator;

/**
 * @author 李重辰
 * @date 2018/11/10 10:28
 */
public class ListIteration {
  public static void main(String[] args) {
    List<Pet> pets = Pets.arrayList(9);
    ListIterator<Pet> it = pets.listIterator();
    while (it.hasNext()) {
      System.out.print(it.previousIndex() + "; ");
      System.out.print(it.next() + ", ");
      System.out.println(it.nextIndex() + ", ");
    }
    System.out.println();
    //Backwards:
    while (it.hasPrevious()) {
      System.out.println(it.previous().id() + " ");
    }
    System.out.println();
    System.out.println(pets);
    // 3为迭代器要返回的第一个元素的索引；可以理解为将游标移动到3
    it = pets.listIterator(3);
    while (it.hasNext()) {
      it.next();
      it.set(Pets.randomPet());
    }
    System.out.println(pets);
  }
}
