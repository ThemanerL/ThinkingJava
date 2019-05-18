package thinkingjava.interfaces;

import thinkingjava.polymorphism.Note;

interface Instrument {
  /**
   * 所有的抽象方法（包括接口中的方法）必须要用javadoc注释、除了返回值、参数、异常说明外，还必须指出该方法做什么事情，实现什么功能
   */
  void adjust();
}

interface Playable {
  /**
   * 所有的抽象方法（包括接口中的方法）必须要用javadoc注释、除了返回值、参数、异常说明外，还必须指出该方法做什么事情，实现什么功能
   *
   * @param n 来自于枚举类
   */
  void play(Note n);
}

/**
 * @author 李重辰
 * @date 2018/10/9 16:43
 */

class Music5 {
  static void tune(Playable i) {
    i.play(Note.MIDDLE_C);
  }

  static void tuneAll(Playable[] e) {
    for (Playable i : e) {
      tune(i);
    }
  }

  public static void main(String[] args) {
    Playable[] orchestra = {
        new Wind(),
        new Percussion(),
        new Stringed(),
        new Brass(),
        new Woodwind()
    };
    tuneAll(orchestra);
  }
}

/**
 * 此处包括二其上二者的定义
 */
abstract class AbstractPlayAndAdjust {
  public void play(Note n) {
    System.out.println(this + ".play" + n);
  }

  public void adjust() {
    System.out.println(this + ".adjust");
  }
}

class Wind extends AbstractPlayAndAdjust implements Instrument, Playable {
  @Override
  public String toString() {
    return "Wind";
  }
}

class Percussion extends AbstractPlayAndAdjust implements Instrument, Playable {
  @Override
  public String toString() {
    return "Percussion";
  }
}

class Stringed extends AbstractPlayAndAdjust implements Instrument, Playable {
  @Override
  public String toString() {
    return "Stringed";
  }
}

class Brass extends Wind {
  @Override
  public String toString() {
    return "Brass";
  }
}

class Woodwind extends Wind {
  @Override
  public String toString() {
    return "Woodwind";
  }
}

