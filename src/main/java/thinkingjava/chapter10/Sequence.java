package thinkingjava.chapter10;

import thinkingjava.chapter10.practice.P2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 当某个外围类的对象创建了一个内部类对象时，此内部类对象必定会秘密地捕获一个指向那个外围类对象的引用。
 * 然后在你访问此外围类的成员时，就是用那个引用来选择外围类的成员。编译器会帮你处理所有的细节
 * 内部类只能在于其外围类的对象相关联的情况下才能被创建（在内部类是非static类时）。
 * <p>
 * <p>
 * 迭代器设计模式的一个例子
 *
 * @author 李重辰
 * @date 2018/10/20 12:27
 */
public class Sequence {

  private Object[] items;
  private int next = 0;

  private Sequence(int size) {
    this.items = new Object[size];
  }

  private void add(Object x) {
    if (next < items.length) {
      //等同于items[next] = x;next ++
      items[next++] = x;
    }
  }

  /**
   * 练习22
   *
   * @return 一个反向遍历的Selector
   */
  Selector reverseSelector() {
    return new Selector() {
      private int i = 0;

      @Override
      public boolean end() {
        return i == items.length;
      }

      @Override
      public Object current() {
        return items[i];
      }

      @Override
      public void next() {
        if (i < items.length) {
          i++;
        }
      }
    };
  }


  /**
   * 这个类中用到了Object[] items，这是一个外部类的private引用。然而内部类可以访问其外围类的方法与字段，就像自己拥有它们似的。
   */
  private class SequenceSelector implements Selector {
    private int i = 0;

    @Override
    public boolean end() {
      return i == items.length;
    }

    @Override
    public Object current() {
      return items[i];
    }

    @Override
    public void next() {
      if (i < items.length) {
        i++;
      }
    }

    private Sequence getSequence() {
      return new Sequence(i);
    }
  }

  private Selector selector() {
    return new SequenceSelector();
  }

  /**
   * 李重辰181108修改：chapter11 Practice9 使用Iterator替代Selector
   * @param args /
   */
  public static void main(String[] args) {
    Sequence sequence = new Sequence(15);
    int j = 10;
    for (int i = 0; i < j; i++) {
      sequence.add(Integer.toString(i));
    }
    j = 5;
    for (int i = 0; i < j; i++) {
      sequence.add(new P2(Integer.toString(i)));
    }
    Selector selector = sequence.selector();
    // chapter11 Practice9
    List<Object> ts = Arrays.asList(sequence.items);
    Iterator<Object> iterator = ts.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next() + " chapter11 Practice9 ");
    }
    //:~
    while (!selector.end()) {
      System.out.println(selector.current() + " ");
      selector.next();
    }
    SequenceSelector sequenceSelector = sequence.new SequenceSelector();
    System.out.println(sequenceSelector.getSequence() + "可以生成对外部类的引用");
    P2 p2 = new P2("temp");
    //必须使用外部类对象来创建内部类对象
    P2.Inner inner = p2.new Inner();
    System.out.println(inner);

    System.out.println("--------practice22-------");
    int sequence1Length = 3;
    Sequence sequence1 = new Sequence(sequence1Length);
    for (int i = 0; i < sequence1Length; i++) {
      sequence1.add(Integer.toString(i));
    }
    Selector selector1 = sequence1.reverseSelector();
    while (!selector1.end()) {
      System.out.println(selector1.current() + " ");
      selector1.next();
    }
  }
}

interface Selector {
  /**
   * 检查序列是否到末尾了
   *
   * @return 标志位
   */
  boolean end();

  /**
   * 访问当前对象
   *
   * @return 返回一个对象数组
   */
  Object current();

  /**
   * 移到序列中的下一个对象
   */
  void next();
}