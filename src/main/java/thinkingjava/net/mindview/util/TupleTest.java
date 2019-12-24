package thinkingjava.net.mindview.util;

/**
 * @author 李重辰
 * @date 2019/12/24 17:33
 */
public class TupleTest {
  public static void main(String[] args) {
    TwoTuple<String, Integer> tt = f();
    System.out.println(tt);
    /// Compile error: final
//     tt.first = "there";
    System.out.println(g());
    System.out.println(h());
    System.out.println(k());
  }

  static TwoTuple<String, Integer> f() {
    // Autoboxing converts the int to Integer:
    return new TwoTuple<>("hi", 47);
  }

  static ThreeTuple<Amphibian, String, Integer> g() {
    return new ThreeTuple<>(
        new Amphibian(), "hi", 47);
  }

  static FourTuple<Vehicle, Amphibian, String, Integer> h() {
    return new FourTuple<>(new Vehicle(), new Amphibian(), "hi", 47);
  }

  static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
    return new FiveTuple<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
  }
}

class Amphibian {
}

class Vehicle {
}