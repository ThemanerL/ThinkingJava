package thinkingjava.chapter10;

/**
 * 一个内部类被嵌套多少层并不重要，它能透明的访问所有它所嵌入的外围类的所有成员包括private
 * Nesting: 嵌套
 * @author 李重辰
 * @date 2018/10/30 21:33
 */
public class MultiNestingAccess {
    public static void main(String[] args) {
        MuNeAccess muNeAccess = new MuNeAccess();
        MuNeAccess.MnaA mnaA = muNeAccess.new MnaA();
        MuNeAccess.MnaA.MnaB mnaB = mnaA.new MnaB();
        mnaB.h();
    }
}

class MuNeAccess{
    private void f(){}
    class MnaA {
        private void g() {}
        class MnaB{
            void h(){
                g();
                f();
            }
        }
    }
}