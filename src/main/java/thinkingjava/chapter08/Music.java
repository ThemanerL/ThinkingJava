package thinkingjava.chapter08;

/**
 * @author 李重辰
 * @date 2018/10/1 10:31
 */
public class Music {
    private static void tune(Instrument i ){
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        Stringed violin  = new Stringed();
        Brass frenchHorn = new Brass();
        tune(flute);
    }
}

class Music2{
    private static void tune(Wind i){
        i.play(Note.MIDDLE_C);
    }

    private static void tune(Stringed i){
        i.play(Note.MIDDLE_C);
    }

    private static void tune(Brass i){
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        Stringed violin  = new Stringed();
        Brass frenchHorn = new Brass();
        tune(flute);
        tune(violin);
        tune(frenchHorn);
    }
}