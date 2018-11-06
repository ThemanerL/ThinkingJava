package thinkingjava.chapter11;

import thinkingjava.thirdparty.typeinfo.pets.Pet;
import thinkingjava.thirdparty.typeinfo.pets.Pets;

import java.util.List;
import java.util.Random;

/**
 * 这里使用了第14章中的类库。
 * 1、有一个Pet类，以及Pet的各种子类型；
 * 2、静态的Pets.arrayList()方法将返回一个填充了随机选取的Pet对象的ArrayList
 * @author 李重辰
 * @date 2018/11/6 21:38
 */
public class ListFeatures {
  public static void main(String[] args) {
    Random rand = new Random(System.currentTimeMillis());
    List<Pet> pets = Pets.arrayList(7);
  }
}
