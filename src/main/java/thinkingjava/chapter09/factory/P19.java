package thinkingjava.chapter09.factory;

import java.util.Random;

/**
 * @author 李重辰
 * @date 2018/10/18 18:27
 */
public class P19 {
    private static void playGamb(GambFactory gambFactory){
        System.out.println(gambFactory.getGambInstance().play());
    }

    public static void main(String[] args) {
        playGamb(new CoinFactory());
        playGamb(new DiceFactory());
    }
}

interface Gamb {
    Random RAND = new Random(System.currentTimeMillis());
    /**
     * 赌
     */
    String play();
}

class Coin implements Gamb{
    private int resultLimt = 2;

    private int point = RAND.nextInt(resultLimt);

    public String play() {
        return "你抛出了"+(point==0?"反面":"正面");
    }
}

class Dice implements Gamb{
    private int resultLimt = 6;

    private int point = RAND.nextInt(resultLimt);

    public String play() {
        return "你抛出了"+point+"点";
    }
}

interface GambFactory {
    /**
     * 实例化赌博
     * @return 返回一个赌博游戏
     */
    Gamb getGambInstance();
}

class CoinFactory implements GambFactory {
    public Gamb getGambInstance() {
        return new Coin();
    }
}

class DiceFactory implements GambFactory {
    public Gamb getGambInstance() {
        return new Dice();
    }
}