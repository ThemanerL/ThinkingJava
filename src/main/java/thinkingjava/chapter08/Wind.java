package thinkingjava.chapter08;

/**
 * Wind 翻译为管乐器
 * @author 李重辰
 * @date 2018/10/1 10:18
 */
class Wind extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
}

/**
 * Stringed 翻译为弦乐
 */
class Stringed extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Stringed().play() " + n);
    }
}

/**
 * Brass 翻译为铜管乐器
 */
class Brass extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Brass().play() " + n);
    }
}
