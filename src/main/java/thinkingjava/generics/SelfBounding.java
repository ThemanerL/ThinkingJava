package thinkingjava.generics;

/**
 * 自限性惯用法
 * 自限定要做的就是在继承关系中，像这个使用这个类
 * class A extends SelfBounded<A> {}
 * 这会强制要求将正在定义的类当做参数传递给基类；
 * 自限定参数可以保证类型参数必须与正在被定义的类相同，请注意，F类可以编译，因此自限定惯用法不是可强制执行的
 *
 * @author 李重辰
 * @date 2020/6/23 17:20
 */
public class SelfBounding {
}

class SelfBounded<T extends SelfBounded<T>> {
  T element;

  T getElement() {
    return element;
  }

  SelfBounded<T> setElement(T element) {
    this.element = element;
    return this;
  }
}

class A extends SelfBounded<A> {
}

class B extends SelfBounded<A> {
}

class D {
}

//Type parameter 'thinkingjava.generics.D' is not within its bound;
// should extend 'thinkingjava.generics.SelfBounded<thinkingjava.generics.D>
//class E extends SelfBounded<D> {
//}

class F extends SelfBounded {
}