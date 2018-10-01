package thinkingjava.chapter05;

/**
 * 创建enum时,编译器会自动添加一些特性.比如会创建toString()方法.可以方便的输出实例的名字
 * 编译器还会创建ordinal()方法,用来表示某个特定enum常量的声明顺序,以及static values()方法,
 * 用来按照enum常量的声明顺序,产生由这些常量值构成的数组
 * @author 李重辰
 * @date 2018/10/1 11:46
 */
public enum Spiciness {
    /**
     * 创建一个名为Spicness的枚举类型,它具有5个具名值.由于枚举类型的实例是常量,
     * 所以按照命名惯例它们都用大写字母表示.
     */
    NOT,
    MILD,
    MEDIUM,
    HOT,
    FLAMING;
}
