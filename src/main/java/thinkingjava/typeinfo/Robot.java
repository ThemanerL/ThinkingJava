package thinkingjava.typeinfo;

import thinkingjava.net.mindview.util.Null;

import java.util.List;

/**
 * @author 李重辰
 * @date 2019/12/20 15:28
 */
public interface Robot {
  /**
   * 名字
   *
   * @return 名字
   */
  String name();

  /**
   * 模型
   *
   * @return 模型
   */
  String model();

  /**
   * 描述Robot行为能力
   *
   * @return 机器人的所有行为能力
   */
  List<Operation> operations();

  class Test {
    public static void test(Robot robot) {
      if (robot instanceof Null) {
        System.out.println("\"Null Robot\"");
      }
      System.out.println("Robot name: " + robot.name());
      System.out.println("Robot model: " + robot.model());
      for (Operation operation : robot.operations()) {
        System.out.println(operation.description());
        operation.command();
      }
    }
  }
}
