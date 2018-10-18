package thinkingjava.chapter09.practice;

import thinkingjava.chapter09.strategy.RandomWords;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * 策略模式练习
 * @author 李重辰
 * @date 2018/10/15 17:31
 */
public class P16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( new AdaptedRandomWords(7));
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}

class AdaptedRandomWords extends RandomWords {
    private static Random rand = new Random(System.currentTimeMillis());
    private int count;

    @Override
    public int read(CharBuffer cb) {
        if(count-- == 0){
            return -1;
        }
        cb.append(CAPITALS[rand.nextInt(CAPITALS.length)]);
        //字符用空格分离
        cb.append(" ");
        return cb.length();
    }

    AdaptedRandomWords(int count) {
        super(count);
        this.count = count;
    }
}