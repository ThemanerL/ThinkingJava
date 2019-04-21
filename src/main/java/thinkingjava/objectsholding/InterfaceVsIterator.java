package thinkingjava.objectsholding;

import thinkingjava.thirdparty.typeinfo.pets.*;

import java.util.*;

/**
 * @author 李重辰
 * @date 2018/11/19 14:19
 */
public class InterfaceVsIterator {
  public static void display(Iterator<Pet> it){
    while (it.hasNext()){
      Pet p = it.next();
      System.out.print(p.id() + ":" + p + " ");
    }
    System.out.println();
  }

  public static void display(Collection<Pet> pets){
    for (Pet p:pets) {
      System.out.print(p.id() + ":" + p + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    List<Pet> petList = Pets.arrayList(8);
    // 此处的HashSet集合没有乱序是因为,Pet类的HashCode混淆后的值,在Name属性为Null时,比较有规律,是根据这个list中Pet生成的顺序递增的
    Set<Pet> petSet = new HashSet<>(petList);
    Map<String, Pet> petMap = new LinkedHashMap<>();
    String[] names = ("Ralph, Eric, Robin, Lacey, " + "Britney, Sam, Spot, Fluffy").split(", ");
    for (int i = 0; i < names.length; i++) {
      petMap.put(names[i], petList.get(i));
    }
    display(petList);
    display(petSet);
    display(petList.iterator());
    display(petSet.iterator());
    System.out.println(petMap);
    System.out.println(petMap.keySet());
    display(petMap.values());
    display(petMap.values().iterator());
  }
}
