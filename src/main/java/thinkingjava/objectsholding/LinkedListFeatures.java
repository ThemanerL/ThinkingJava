package thinkingjava.objectsholding;

import thinkingjava.thirdparty.typeinfo.pets.Hamster;
import thinkingjava.thirdparty.typeinfo.pets.Pet;
import thinkingjava.thirdparty.typeinfo.pets.Pets;
import thinkingjava.thirdparty.typeinfo.pets.Rat;

import java.util.LinkedList;

/**
 * @author 李重辰
 * @date 2018/11/11 17:07
 */
public class LinkedListFeatures {
  public static void main(String[] args) {
    LinkedList<Pet> pets = new LinkedList<>(Pets.arrayList(5));
    System.out.println(pets);
    // 这两个方法完全一样
    System.out.println("pets.getFirst(): " + pets.getFirst());
    System.out.println("pets.element(): " + pets.element());
    System.out.println("pets.peek(): " + pets.peek());
    System.out.println("pets.remove(): " + pets.remove());
    System.out.println("pets.removeFirst(): " + pets.removeFirst());
    System.out.println("pets.poll(): " + pets.poll());
    System.out.println(pets);
    pets.addFirst(new Rat());
    System.out.println("After addFirst(): " + pets);
    pets.offer(Pets.randomPet());
    System.out.println("After offer(): " + pets);
    pets.add(Pets.randomPet());
    System.out.println("After add(): " + pets);
    pets.addLast(new Hamster());
    System.out.println("After addLast(): " + pets);
    System.out.println("pets.removeLast(0: " + pets.removeLast());
    System.out.println(pets);
  }
}
