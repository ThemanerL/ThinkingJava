package thinkingjava.chapter04;

/**
 * 成员变量:需要手动提供一鞥初始值,只要创建对象,就会在构造器之前初始化成员变量,存在于对象所在的堆内存中。
 * 静态变量:随着类加载被初始化,存放于方法区,可以不手动赋予一个默认值.
 * 局部变量:可以没有默认初始化值,先定义赋值后才可使用,存放在栈中.
 * @author 李重辰
 * @date 2018/9/24
 */
public class OrderOfInitialization {
    public static void main(String[] args){
        Card t = new Card();
        t.f();
    }
}
class Tag {
    Tag(int maker){
        System.out.println("Tag("+maker+")");
    }
}
class Card {
    Tag t1 = new Tag(1);
    Card(){
        int f = 3;
        System.out.println("Card()");
        t3 = new Tag(33);
    }
    Tag r2 = new Tag(2);
    void f() {
        System.out.println("f()");
    }
    Tag t3 = new Tag(3);
}
