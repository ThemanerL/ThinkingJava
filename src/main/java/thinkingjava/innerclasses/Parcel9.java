package thinkingjava.innerclasses;

/**
 * 在匿名类定义字段时，还能够对其执行初始化操作。
 * 如果定义一个匿名内部类，并且希望它使用一个在其外部定义的对象，那么编译器会要求其参数引用是final的。
 * <p>
 * （1）这里之所以只能用final修饰的参数，是变量作用域的原因。虽然匿名内部类被定义在方法内部，但匿名内部类是单独的个体，
 * 编译时随外部类一起被编译成为Outer$1.class文件，并不是方法被调用时才会被执行。方法中的局部变量只是在方法被调用
 * 时被创建在栈内存中，调用完毕会自动清空栈，所以，匿名内部类要想使用方法内部的变量，只能将该变量用final修饰，即定义为常量。
 * <p>
 * （2）JVM中每个进程都会有多个根,每个static变量,方法参数,局部变量,当然这都是指引用类型.基础类型是不能作为根的,根其实就是
 * 一个存储地址.垃圾回收器在工作时先从根开始遍历它引用的对象并标记它们,如此递归到最末梢,所有根都遍历后,没有被标记到的对象
 * 说明没有被引用,那么就是可以被回收的对象(有些对象有finalized方法,虽然没有引用,但JVM中有一个专门的队列引用它们直到finalized
 * 方法被执行后才从该队列中移除成为真正没有引用的对象,可以回收,这个与本主题讨论的无关,包括代的划分等以后再说明).这看起来很好.
 * 但是在内部类的回调方法中,s既不可能是静态变量,也不是方法中的临时变量,也不是方法参数,它不可能作为根,在内部类中也没有变量引
 * 用它,它的根在内部类外部的那个方法中,如果这时外面变量s重指向其它对象,则回调方法中的这个对象s就失去了引用,可能被回收,而由于
 * 内部类回调方法大多数在其它线程中执行,可能还要在回收后还会继续访问它.
 * 而使用final修饰符不仅会保持对象的引用不会改变,而且编译器还会持续维护这个对象在回调方法中的生命周期.所以这才是final变量和
 * final参数的根本意义.
 *
 * @author 李重辰
 * @date 2018/10/24 21:30
 */
public class Parcel9 {
  public static void main(String[] args) {
    Parcel9 parcel9 = new Parcel9();
    Destination destination = parcel9.destination("Down");
  }

  private Destination destination(final String dest) {
    return new Destination() {
      private String label = dest;

      @Override
      public String readLabel() {
        return label;
      }
    };
  }
}
