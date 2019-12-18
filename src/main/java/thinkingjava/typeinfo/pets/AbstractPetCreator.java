package thinkingjava.typeinfo.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author 李重辰
 * @date 2019/12/18 7:32
 */
public abstract class AbstractPetCreator {
  private Random random = new Random(System.currentTimeMillis());

  /**
   * 该抽象方法在导出类中实现，以获取由Class对象构成的List（这是模版方法设计模式的一种变体）。
   * 注意：其中类的类型被指定为“任何从Pet中导出的类”，因此newInstance()不需要转型就可以产生Pet。
   *
   * @return 以Class对象构成的List
   */
  public abstract List<Class<? extends Pet>> getTypes();

  public Pet randomPet() {
    int n = random.nextInt(getTypes().size());
    try {
      return getTypes().get(n).newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  public Pet[] createArray(int size) {
    Pet[] result = new Pet[size];
    /// 这种遍历方式应该也是可行的。待测试
//    for (Pet item:result) {
//      item = randomPet();
//    }
    for (int i = 0; i < result.length; i++) {
      result[i] = randomPet();
    }
    return result;
  }

  public ArrayList<Pet> arraysList(int size) {
    ArrayList<Pet> result = new ArrayList<>();
    Collections.addAll(result, createArray(size));
    return result;
  }
}
