package thinkingjava.objectsholding.practice;

import thinkingjava.thirdparty.typeinfo.pets.Pet;
import thinkingjava.thirdparty.typeinfo.pets.Pets;

import java.util.*;

/**
 * @author 李重辰
 * @date 2018/11/8 21:41
 */
public class P11 {
  void printToString(Collection collection){
    Iterator iterator = collection.iterator();
    while(iterator.hasNext()){
      System.out.println(iterator.next().toString());
    }
  }

  public static void main(String[] args) {
    P11 p11 = new P11();
    ArrayList<Pet> pets = Pets.arrayList(8);
    LinkedList<Pet> petLinkedList = new LinkedList<>(pets);
    HashSet<Pet> petHashSet = new HashSet<>(pets);
    TreeSet<Pet> petTreeSet = new TreeSet<>(pets);
    p11.printToString(pets);
    System.out.println();
    p11.printToString(petLinkedList);
    System.out.println();
    p11.printToString(petHashSet);
    System.out.println();
    p11.printToString(petTreeSet);
  }
}
