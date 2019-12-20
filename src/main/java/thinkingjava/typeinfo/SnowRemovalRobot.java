package thinkingjava.typeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * @author 李重辰
 * @date 2019/12/20 15:50
 */
public class SnowRemovalRobot implements Robot {
  private String name;

  public SnowRemovalRobot(String name) {
    this.name = name;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public String model() {
    return "SnowBot series l1";
  }

  @Override
  public List<Operation> operations() {
    return Arrays.asList(
        new Operation() {
          @Override
          public String description() {
            return name + " can shovel snow[铲雪]";
          }

          @Override
          public void command() {
            System.out.println(name + " shovel snow");
          }
        },
        new Operation() {
          @Override
          public String description() {
            return name + " can ship ice";
          }

          @Override
          public void command() {
            System.out.println(name + " chipping ice");
          }
        },
        new Operation() {
          @Override
          public String description() {
            return name + " can clear the roof";
          }

          @Override
          public void command() {
            System.out.println(name + " clearing root");
          }
        }
    );
  }

  public static void main(String[] args) {
    Robot.Test.test(new SnowRemovalRobot("Sakura"));
  }
}
