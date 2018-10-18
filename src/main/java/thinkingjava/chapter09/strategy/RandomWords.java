package thinkingjava.chapter09.strategy;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * 接口的一种常见用法就是“策略设计模式”，测试你编写一个执行某些操作的方法。而该方法将接受一个同样是你指定的接口。
 * 你主要就是声明：“你可以用任何你想要的对象来调用我的方法，只要你的对象遵循我的接口。”这使得你的方法更加灵活，通过，
 * 并更具有可复用性
 * <p>
 * Scanner类的构造器接受的就是一个Readable接口，你会发现Readable没有用作Java标准类库中其他方法的参数，它是单独为Scanner创建的，
 * 以使得Scanner不必将其参数限制为某个特定类。通过这种方式，Scanner可以作用于更多的类型。如果你创建了一个新的类，并且向让Scanner
 * 可以作用于它，那么你就应该让它成为Readable
 *
 * @author 李重辰
 * @date 2018/10/13 10:24
 */
public class RandomWords implements Readable {
    private static Random rand = new Random(System.currentTimeMillis());
    public static final char[] CAPITALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] LOWERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] VOWELS = "aeiou".toCharArray();
    private int count;

    protected RandomWords (int count) {
        this.count = count;
    }

    public int read(CharBuffer cb) {
        int casual = 4;
        if (count-- == 0){
            //Indicates end of input
            return -1;
        }
            cb.append(CAPITALS[rand.nextInt(CAPITALS.length)]);
            for (int i = 0; i < casual; i++){
                cb.append(VOWELS[rand.nextInt(VOWELS.length)]);
                cb.append(LOWERS[rand.nextInt(LOWERS.length)]);
        }
        cb.append(" ");
        //Numbers of characters append
        return 10;
    }

    /**
     * 这一块代码关于Scanner的详细调用顺序栈 留待第十三章仔细分析
     * 在read()方法内部，将输入内容
     * @param args 控制台参数
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomWords(10));
        while(s.hasNext()){
            System.out.println(s.next());
        }
    }
}

class RandomDoubles{
    private static Random rand = new Random(System.currentTimeMillis());
    double next(){
        return rand.nextDouble();
    }
    public static void main(String[] args) {
        int casual = 7;
        RandomDoubles rd = new RandomDoubles();
        for (int i = 0; i < casual; i++) {
            System.out.println(rd.next() + " ");
        }
    }
}