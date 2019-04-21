package thinkingjava.objectsholding;

import thinkingjava.thirdparty.typeinfo.pets.Pet;
import thinkingjava.thirdparty.typeinfo.pets.Pets;

import java.util.*;

/**
 * @author 李重辰
 * @date 2018/11/8 20:38
 */
public class CrossContainerIteration {
  /**
   * display不包含任何有关它所遍历的序列的类型信息，迭代器统一了对容器的访问方式
   * @param petIterator
   */
  private static void display(Iterator<Pet> petIterator){
    while (petIterator.hasNext()){
      Pet pet = petIterator.next();
      System.out.print(pet.id() + ":" + pet + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ArrayList<Pet> pets = Pets.arrayList(8);
    LinkedList<Pet> petLinkedList = new LinkedList<>(pets);
    HashSet<Pet> petHashSet = new HashSet<>(pets);
    TreeSet<Pet> petTreeSet = new TreeSet<>(pets);
    display(pets.iterator());
    display(petLinkedList.iterator());
    display(petHashSet.iterator());
    display(petTreeSet.iterator());
  }
}
