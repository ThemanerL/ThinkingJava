package thinkingjava.typeinfo;

/**
 * @author 李重辰
 * @date 2019/12/16 20:39
 */
public class ClassCasts {
  public static void main(String[] args) {
    Building building = new Building();
    Class<House> houseClass = House.class;
    House house = houseClass.cast(building);
    house = (House)building;
  }
}

class Building {}

class House extends Building{}