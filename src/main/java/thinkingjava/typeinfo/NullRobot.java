package thinkingjava.typeinfo;

import thinkingjava.net.mindview.util.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 * @author 李重辰
 * @date 2019/12/20 16:50
 */
public class NullRobot {
  public static Robot newNullRobot(Class<? extends Robot> type) {
    return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(), new Class[]{Null.class, Robot.class}, new NullRobotProxyHandle(type));
  }

  public static void main(String[] args) {
    Robot[] bots = {new SnowRemovalRobot("SnowBee"), newNullRobot(SnowRemovalRobot.class)};
    for (Robot bot : bots) {
      Robot.Test.test(bot);
    }
  }
}

class NullRobotProxyHandle implements InvocationHandler {
  private String nullName;

  private Robot proxied = new NRobot();

  public NullRobotProxyHandle(Class<? extends Robot> type) {
    this.nullName = type.getSimpleName() + " NullRobot";
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    return method.invoke(proxied, args);
  }

  private class NRobot implements Null, Robot {
    @Override
    public String model() {
      return nullName;
    }

    @Override
    public List<Operation> operations() {
      return Collections.emptyList();
    }

    @Override
    public String name() {
      return nullName;
    }
  }
}
