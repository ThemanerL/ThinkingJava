package thinkingjava.chapter11;

import thinkingjava.thirdparty.typeinfo.pets.Person;
import thinkingjava.thirdparty.typeinfo.pets.Pet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李重辰
 * @date 2018/11/13 21:54
 */
public class MapOfList {
  public static Map<Person, List<? extends Pet>> petPeople = new HashMap<>();
  static {

  }
}
