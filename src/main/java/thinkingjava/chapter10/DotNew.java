package thinkingjava.chapter10;

/**
 * 要想创建内部类的对象，不能按照你想象的方式去引用外部类的名字DotNew，而是必须使用外部类的对象来创建该内部类对象。
 * 这也解决了内部类名字作用域的问题，因此不能声明dn.new DotNew.Inner()
 * @author 李重辰
 * @date 2018/10/22 10:58
 */
public class DotNew {
    private class Inner {}

    public static void main(String[] args) {
        DotNew dotNew = new DotNew();
        DotNew.Inner dni = dotNew.new Inner();
    }
}
