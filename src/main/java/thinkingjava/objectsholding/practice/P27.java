package thinkingjava.objectsholding.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 李重辰
 * @date 2018/11/19 12:24
 */
class P27 {
  Queue<Command> fillCommand() {
    return new LinkedList<>(Arrays.asList(new Command("8"), new Command("1"), new Command("2")));
  }
}

class Main {
  public static void main(String[] args) {
    Main main = new Main();
    main.printQueue(new P27().fillCommand());
  }

  private void printQueue(Queue<Command> queue) {
    while (queue.peek() != null) {
      queue.poll().operation();
    }

  }
}

class Command {
  String string;

  void operation() {
    System.out.println(string);
  }

  Command(String string) {
    this.string = string;
  }
}