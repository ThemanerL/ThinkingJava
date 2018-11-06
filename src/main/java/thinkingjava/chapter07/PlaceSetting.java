package thinkingjava.chapter07;

/**
 * 编译器会强迫我们对基础类进行初始化，并要求我们在构建器最开头做这一工作，但它并不会监视我们是否正确初始化了成员对象。
 * 所有对此必须特别留意。
 *
 * @author 李重辰
 * @date 2018/9/27 18:10
 */
public class PlaceSetting extends Custom {
  Spoon spoon;
  Fork fork;
  Knife knife;
  DinnerPlate dinnerPlate;

  PlaceSetting(int i) {
    super(i + 1);
    spoon = new Spoon(i + 2);
    fork = new Fork(i + 3);
    knife = new Knife(i + 4);
    dinnerPlate = new DinnerPlate(i + 5);
    System.out.println("PlaceSetting constructor");
  }

  public static void main(String[] args) {
    PlaceSetting x = new PlaceSetting(9);
  }
}

class Plate {
  Plate(int i) {
    System.out.println("Plate constructor");
  }
}

class DinnerPlate extends Plate {
  DinnerPlate(int i) {
    super(i);
    System.out.println("DinnerPlate constructor");
  }
}

class Utensil {
  Utensil(int i) {
    System.out.println("Utensil constructor");
  }
}

class Spoon extends Utensil {
  Spoon(int i) {
    super(i);
    System.out.println("Spoon constructor");
  }
}

class Fork extends Utensil {
  Fork(int i) {
    super(i);
    System.out.println("Fork constructor");
  }
}

class Knife extends Utensil {
  Knife(int i) {
    super(i);
    System.out.println("Knife constructor");
  }
}

class Custom {
  Custom(int i) {
    System.out.println("Custom constructor");
  }
}