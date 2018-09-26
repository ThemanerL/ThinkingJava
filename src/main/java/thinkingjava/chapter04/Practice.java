package thinkingjava.chapter04;

/**
 * @author 李重辰
 * @date 2018/9/26 15:27
 */
public class Practice {
    Practice(){
        class Print{
            Print(){
                System.out.println("用默认构建器创建一个类（没有自变量），用它打印一条消息。创建属于这个类的一个对象:练习（1）");
            }
        }
        new Print();
    }

    Practice(String message){
        class Print{
            Print(String message){
                System.out.println("增加一个过载的构建器，令其采用一个String自变量，并随同自己的消息打印出来："+message);

            }
        }
        new Print(message);
    }

    public static void main(String[] args) {
        new Practice();
        Practice[] p3 = new Practice[5];
        p3[0] = new Practice("练习3");
    }
}
