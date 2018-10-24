package thinkingjava.chapter10;

/**
 * 如果你的基类需要一个有参数的构造器，只需简单地传递合适的参数给基类的构造器即可。这里是将x传进new Wrapping(x)。
 * Wrapping 只是一个具有具体实现的普通类，但是在这是被其导出类当做公共“接口”来使用。
 *
 * @author 李重辰
 * @date 2018/10/24 21:18
 */
public class Parcel8 {

    private Wrapping wrapping(int x){
        // 内部的这个类是没有名字的，即匿名类
        return new Wrapping(x){
            @Override
            public int value() {
                return  super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        Wrapping wrapping =  parcel8.wrapping(88);
        wrapping.value();
    }
}
