package thinkingjava.generics;

import thinkingjava.net.mindview.util.FourTuple;


import java.util.ArrayList;

/**
 * @author 李重辰
 * @date 2019/12/25 20:53
 */
public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {
  public static void main(String[] args) {
    TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<>();
    tl.add(TupleTest.h());
    tl.add(TupleTest.h());
    for(FourTuple<Vehicle,Amphibian,String,Integer> i: tl) {
      System.out.println(i);
    }
  }
}
