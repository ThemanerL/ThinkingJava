package thinkingjava.chapter07;

/**
 * @author 李重辰
 * @date 2018/9/27 17:58
 */
public class Chess extends BoardGame {
  Chess() {
    super(11);
    System.out.println("Chess constructor");
  }

  public static void main(String[] args) {
    new Chess();
  }
}

class Game {
  Game(int i) {
    System.out.println("Game constructor : " + i);
  }
}

class BoardGame extends Game {
  BoardGame(int i) {
    super(i);
    System.out.println("BoardGame constructor");
  }
}
