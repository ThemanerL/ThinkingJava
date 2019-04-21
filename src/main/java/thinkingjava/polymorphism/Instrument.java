package thinkingjava.polymorphism;

/**
 * @author 李重辰
 * @date 2018/10/1 10:15
 */
class Instrument {
  public void play(Note n) {
    System.out.println("Instrument.play " + n);
  }

  public String what() {
    return "Instrument.what ";
  }

  public void adjust() {
    System.out.println("Instrument.adjust ");
  }
}

/**
 * Wind 翻译为管乐器
 */
class Wind extends Instrument {
  @Override
  public void play(Note n) {
    System.out.println("Wind.play " + n);
  }

  @Override
  public String what() {
    return "Wind.what ";
  }

  @Override
  public void adjust() {
    System.out.println("Wind.adjust ");
  }
}

class WoodWind extends Wind {
  @Override
  public void play(Note n) {
    System.out.println("WoodWind.play " + n);
  }

  @Override
  public String what() {
    return "WoodWind.what ";
  }
}

class Percussion extends Instrument {
  @Override
  public void play(Note n) {
    System.out.println("Percussion.play " + n);
  }

  @Override
  public String what() {
    return "Percussion.what ";
  }

  @Override
  public void adjust() {
    System.out.println("Percussion.adjust ");
  }
}

/**
 * Stringed 翻译为弦乐
 */
class Stringed extends Instrument {
  @Override
  public void play(Note n) {
    System.out.println("Stringed.play " + n);
  }

  @Override
  public String what() {
    return "Stringed,what ";
  }

  @Override
  public void adjust() {
    System.out.println("Stringed.adjust ");
  }

}

/**
 * Brass 翻译为铜管乐器
 */
class Brass extends Wind {
  @Override
  public void play(Note n) {
    System.out.println("Brass.play " + n);
  }

  @Override
  public void adjust() {
    System.out.println("Brass.adjust ");
  }
}