package thinkingjava.chapter11.practice;

import java.util.*;

/**
 * @author 李重辰
 * @date 2018/11/8 18:14
 */
public class P5 {
  public static void main(String[] args) {
    Random rand = new Random(System.currentTimeMillis());
    List<Integer> pets = new ArrayList<>();
    int initPetsSize = 8;
    for (int i = 1; i < initPetsSize; i++) {
      pets.add(i);
    }
    System.out.println("1: " + pets);
    Integer hamster = 8;
    pets.add(hamster);
    System.out.println("2: " + pets);
    System.out.println("3: " + pets.contains(hamster));
    pets.remove(hamster);
    Integer pet = pets.get(2);
    System.out.println("4: " + pet + " " + pets.indexOf(pet));
    Integer cymric = 9;
    System.out.println("5: " + pets.indexOf(cymric));
    System.out.println("6: " + pets.remove(cymric));
    System.out.println("7: " + pets.remove(pet));
    System.out.println("8: " + pets);
    pets.add(3, 10);
    System.out.println("9: " + pets);
    List<Integer> sub = pets.subList(1, 4);
    System.out.println("subList: " + sub);
    System.out.println("10: " + pets.containsAll(sub));
    Collections.sort(sub);
    System.out.println("Sorted subList: " + sub);
    // 顺序对于containsAll没有影响
    System.out.println("11 " + pets.containsAll(sub));
    //使用指定的随机源置换指定的列表
    Collections.shuffle(sub, rand);
    System.out.println("shuffled subList: " + sub);
    System.out.println("12: " + pets.containsAll(sub));
    List<Integer> copy = new ArrayList<>(pets);
    sub = Arrays.asList(pets.get(1),pets.get(4));
    System.out.println("sub: " + sub);
    //从copy中删除所有不在sub中的元素
    copy.retainAll(sub);
    System.out.println("13: " + copy);
    copy = new ArrayList<>(pets);
    System.out.println("13-1: " + copy);
    copy.remove(2);
    System.out.println("14: " + copy);
    copy.removeAll(sub);
    System.out.println("15: " + copy);
    copy.set(1, 10);
    System.out.println("16: " + copy);
    copy.addAll(2,sub);
    System.out.println("17: " + copy);
    System.out.println("18: " + pets.isEmpty());
    /// subList返回原来list的从[fromIndex, toIndex)之间这一部分的视图，之所以说是视图，是因为实际上，返回的list是靠原来的list支持的
    // 如果发生结构性修改的是返回的子list，那么原来的list的大小也会发生变化；
    // 而如果发生结构性修改的是原来的list（不包括由于返回的子list导致的改变），那么返回的子list语义上将会是undefined。
    // 在AbstractList（ArrayList的父类）中，undefined的具体表现形式是抛出一个ConcurrentModificationException。
    // 所以一定要特别注意对sublist的修改
    //pets.clear();
    System.out.println("19: " + pets);
    System.out.println("20: " + pets.isEmpty());
    pets.addAll(Arrays.asList(1, 2, 3, 4));
    System.out.println("21: " + pets);
    Object[] o = pets.toArray();
    System.out.println("22: " + o[3]);
  }
}
