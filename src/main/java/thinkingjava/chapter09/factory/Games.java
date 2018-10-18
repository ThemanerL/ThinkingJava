package thinkingjava.chapter09.factory;

/**
 * @author 李重辰
 * @date 2018/10/18 17:26
 */
public class Games {
    private static void playGame(GameFactory factory) {
        Game s = factory.getGame();
        // 这是故意写的空while体
        while (s.move()){
            ;
        }
    }

    public static void main(String[] args) {
        playGame(new CheckersFactory());
        playGame(new ChessFactory());
    }
}

interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {
    private int moves = 0;
    private static final int MOVES = 3;

    public boolean move() {
        System.out.println("Checkers move " + moves);
        //先将moves的值进行自加再与表达式右边进行比较
        return ++moves != MOVES;
    }

}

class CheckersFactory implements GameFactory {
    public Game getGame() {
        return new Checkers();
    }
}

class Chess implements Game {
    private int moves = 0;
    private static final int MOVES = 4;

    public boolean move() {
        System.out.println("Chess move" + moves);
        return ++moves != MOVES;
    }
}

class ChessFactory implements GameFactory {
    public Game getGame() {
        return new Chess();
    }
}