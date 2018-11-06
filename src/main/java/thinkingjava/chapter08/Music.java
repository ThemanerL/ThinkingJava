package thinkingjava.chapter08;

import java.util.Random;

/**
 * @author 李重辰
 * @date 2018/10/1 10:31
 */
public class Music {
  private static void tune(Instrument i) {
    i.play(Note.MIDDLE_C);
  }

  public static void main(String[] args) {
    Wind flute = new Wind();
    Stringed violin = new Stringed();
    Brass frenchHorn = new Brass();
    tune(flute);
  }
}

class Music2 {
  private static void tune(Wind i) {
    i.play(Note.MIDDLE_C);
  }

  private static void tune(Stringed i) {
    i.play(Note.MIDDLE_C);
  }

  private static void tune(Brass i) {
    i.play(Note.MIDDLE_C);
  }

  public static void main(String[] args) {
    Wind flute = new Wind();
    Stringed violin = new Stringed();
    Brass frenchHorn = new Brass();
    tune(flute);
    tune(violin);
    tune(frenchHorn);
  }
}

class Music3 {
  private static void tune(Instrument i) {
    if (i == null) {
      return;
    }
    i.play(Note.MIDDLE_C);
  }

  private static void tuneAll(Instrument[] e) {
    for (Instrument i : e
    ) {
      tune(i);
    }
  }

  private static Instrument createObject() {
    Random random = new Random(System.currentTimeMillis());
    switch (random.nextInt(5)) {
      case 0:
        return new Wind();
      case 1:
        return new Percussion();
      case 2:
        return new Stringed();
      case 3:
        return new Brass();
      case 4:
        return new WoodWind();
      default:
        return null;
    }
  }

  public static void main(String[] args) {
    Instrument orchestra = createObject();


//        Instrument[] orchestra = {
//                new Wind(),new Percussion(),new Stringed(),new Brass(),new WoodWind()
//        };
    tune(orchestra);
  }
}