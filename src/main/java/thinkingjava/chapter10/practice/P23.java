package thinkingjava.chapter10.practice;

/**
 * @author 李重辰
 * @date 2018/10/31 21:10
 */
public class P23 {
    public static void main(String[] args) {
        InterfaceU.ClassA[] a = new InterfaceU.ClassA[5];
        for ( InterfaceU.ClassA i: a) {
            a[i] =
        }
        InterfaceU.ClassB b = new InterfaceU.ClassB();
        for (InterfaceU.ClassA i: a) {
             b.addUS(i.getInstance());
        }
        b.eachUS();
        b.toNull();
    }
}

interface InterfaceU{

    class ClassA{
        InterfaceU getInstance(){
            return new InterfaceU() {};
        }
    }

    class ClassB{
        int arraySize = 5;
        int flag = 0;
        InterfaceU[] interfaceUS  =  new InterfaceU[arraySize];

        void addUS(InterfaceU interfaceU){
            interfaceUS[flag++] = interfaceU;
        }

        void toNull(){
            for (int i = 0; i<interfaceUS.length; i++){
                interfaceUS[i] = null;
            }
        }

        void  eachUS(){
            for (InterfaceU u:
            interfaceUS) {
                System.out.println(u);
            }
        }
    }
}
