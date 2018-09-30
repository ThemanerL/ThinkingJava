package thinkingjava.chapter07.practice;

/**
 * final方法不可被重写
 * @author 李重辰
 * @date 2018/9/30 15:53
 */
public class P21{
   /* @Override
    public final void printName(){

    }*/
}

/*public class P21 extends PclassOrigin{
   *//* @Override
    public final void printName(){

    }*//*
}*/

/**
 * final类的域可以根据个人意愿选择为是不是final。不论类是不是final，相同的规则都适用于定义为final的域。
 * 但是，由于final类禁止继承，所以final类中所有的方法都隐式的是final的。因为无法覆盖他们。
 * 在final类中可以给方法添加final修饰词，但是这没有任何意义。
 */
final class PclassOrigin{
    public final void printName(){
        System.out.println(this.getClass().getSimpleName());
    }
}

