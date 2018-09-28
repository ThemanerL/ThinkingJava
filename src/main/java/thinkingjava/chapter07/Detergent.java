package thinkingjava.chapter07;

/**
 * @author 李重辰
 * @date 2018/9/27 15:04
 */
public class Detergent extends Cleanser {
    /**
     * Change a method:
     */
    @Override
    public void scrub() {
        append(" Detergent.scrub()");
        // Call base-class version，此处如果只是点单的调用scrub()，会造成递归调用。
        super.scrub();
    }

    /**
     * Add methods to the interface:
     */
    public void foam() {
        append(" foam()");
    }

    /**
     * Test the new class:
     */
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        x.print();
        System.out.println("Testing base class:");
        Cleanser.main(args);
    }
}

/**
 * ThinkJava 第四版 P144
 * 倘若省略所有的访问指示符，则成员默认为“友好的”。这样一来，就只允许对包成员进行访问。在这个包内，任何人都可使用那些没有访问控制符的方法。
 * 例如，Detergent将不会遇到任何麻烦。然而，假设来自另外某个包的类准备继承Cleanser，他就只能访问那些public成员。所以在计划继承的时候，一个
 * 比较好的规则是，将所有的字段都设为private，并将所有的方法设为public（protected以后讨论）。在一些特殊场合这不是一个好的做法。
 */
class Cleanser {
    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    public void print() {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        x.print();
    }
}

/**
 * 这个类的代理方法是使用IDEA自动生成的。
 */
class DetergentFromIdea{
    private Cleanser cleanser;

    public void append(String a) {
        cleanser.append(a);
    }

    public void dilute() {
        cleanser.dilute();
    }

    public void apply() {
        cleanser.apply();
    }

    public void scrub() {
        cleanser.scrub();
    }

    public void print() {
        cleanser.print();
    }

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.foam();
        x.dilute();
        x.apply();
        x.scrub();
        x.print();
        Cleanser.main(args);
    }
}
