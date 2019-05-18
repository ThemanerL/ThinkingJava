package thinkingjava.interfaces.factory;

interface Game {
  /**
   * 移动旗子
   *
   * @return boolean
   */
  boolean move();
}

interface GameFactory {
  /**
   * 创建游戏实例
   *
   * @return 游戏
   */
  Game getGame();
}

/**
 * @author 李重辰
 * @date 2018/10/18 17:26
 */
public class Games {
  private static void playGame(GameFactory factory) {
    Game s = factory.getGame();
    // 这是故意写的空while体
    while (s.move()) {
    }
  }

  public static void main(String[] args) {
    playGame(new CheckersFactory());
    playGame(new ChessFactory());
  }
}

class Checkers implements Game {
  private static final int MOVES = 3;
  private int moves = 0;

  @Override
  public boolean move() {
    System.out.println("Checkers move " + moves);
    //先将moves的值进行自加再与表达式右边进行比较
    return ++moves != MOVES;
  }

}

class CheckersFactory implements GameFactory {
  @Override
  public Game getGame() {
    return new Checkers();
  }
}

class Chess implements Game {
  private static final int MOVES = 4;
  private int moves = 0;

  @Override
  public boolean move() {
    System.out.println("Chess move" + moves);
    return ++moves != MOVES;
  }
}

class ChessFactory implements GameFactory {
  @Override
  public Game getGame() {
    return new Chess();
  }
}