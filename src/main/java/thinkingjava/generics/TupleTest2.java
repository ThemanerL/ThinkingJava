package thinkingjava.generics;

import thinkingjava.net.mindview.util.*;
import thinkingjava.reusing.practice.Amphibian;

import static thinkingjava.net.mindview.util.Tuple.tuple;

/**
 * @author 李重辰
 * @date 2019/12/25 19:53
 */
public class TupleTest2 {
  static TwoTuple<String, Integer> f() {
    return tuple("hi", 47);
  }

  static TwoTuple<String, Integer> f2() {
    return tuple("hi", 47);
  }

  static ThreeTuple<Amphibian, String, Integer> g() {
    return tuple(new Amphibian(), "hi", 47);
  }

  static FourTuple<Vehicle, Amphibian, String, Integer> h() {
    return tuple(new Vehicle(), new Amphibian(), "hi", 47);
  }

  static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
    return tuple(new Vehicle(), new Amphibian(),
        "hi", 47, 11.1);
  }

  public static void main(String[] args) {
    TwoTuple<String, Integer> tt = f();
    System.out.println(tt);
    System.out.println(f2());
    System.out.println(g());
    System.out.println(h());
    System.out.println(k());
  }
}
