package thinkingjava.chapter11.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author 李重辰
 * @date 2018/11/2 20:18
 */
public class Gerbil implements Comparable{
  private int gerbilNumber;

  public Gerbil(int gerbilNumber) {
    this.gerbilNumber = gerbilNumber;
  }

  void hop() {
    System.out.println(gerbilNumber + ": Jumping!");
  }

  @Override
  public int compareTo(Object o) {
    return this.gerbilNumber - ((Gerbil)o).gerbilNumber ;
  }

  public static void main(String[] args) {
    List<Gerbil> gerbils = new ArrayList<>();
    gerbils = new LinkedList<>();
    int j = 4;
    for (int i = 0; i < j; i++) {
      gerbils.add(new Gerbil(i));
    }

    for (int i = 0; i < j; i++) {
      gerbils.get(i).hop();
    }

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Gerbil))
    {
      return false;
    }
    Gerbil gerbil = (Gerbil) o;
    return gerbilNumber == gerbil.gerbilNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(gerbilNumber);
  }
}
