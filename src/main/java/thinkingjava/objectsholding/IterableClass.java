package thinkingjava.objectsholding;

import java.util.Iterator;

/**
 * @author 李重辰
 * @date 2018/11/21 12:08
 */
public class IterableClass implements Iterable<String> {
  String[] words = ("And that is how " + "we know the Earth to be banana-shaped ").split(" ");

  @Override
  public Iterator<String> iterator() {
    return new Iterator<String>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        return index < words.length;
      }

      @Override
      public String next() {
        return words[index++];
      }
    };
  }

  public static void main(String[] args) {
    for (String s: new IterableClass() ){
      System.out.print(s + " ");
    }
  }
}
