package thinkingjava.typeinfo.practice;

import thinkingjava.factory.Factory;
import thinkingjava.net.mindview.util.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

interface IPart {
}

/**
 * practice24:Add Null Objects to RegisteredFactories.java
 * 添加一个空对象到RegisteredFactories
 *
 * @author 李重辰
 * @date 2019/12/19 11:39
 */
public class P24 {
  public static void main(String[] args) {
    int loops = 20;
    for (int i = 0; i < loops; i++) {
      IPart random = Part1.createRandom();
      System.out.println(random);
    }
  }
}

class NullPartInvocationHandle implements InvocationHandler {

  NullPart1 proxied = new NullPart1();

  String className;

  public NullPartInvocationHandle(IPart c) {
    this.className = c.getClass().getSimpleName();
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) {
    try {
      return method.invoke(proxied, args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }
    return null;
  }

  private class NullPart1 extends Part1 implements Null {
    @Override
    public String toString() {
      return "Null Object" + className;
    }
  }
}

class Part1 implements IPart {

  static List<Factory<? extends Part1>> partFactories = new ArrayList<>();
  private static Random rand = new Random(System.currentTimeMillis());

  static {
    partFactories.add(new FuelFilter1.Factory());
    partFactories.add(new AirFilter1.Factory());
    partFactories.add(new CabinAirFilter1.Factory());
    partFactories.add(new OilFilter1.Factory());
    partFactories.add(new FanBelt1.Factory());
    partFactories.add(new PowerSteeringBelt1.Factory());
    partFactories.add(new GeneratorBelt1.Factory());
  }

  static IPart createRandom() {
    int n = rand.nextInt(partFactories.size());
    IPart aClass = partFactories.get(n).create();
    return (IPart) Proxy.newProxyInstance(Part1.class.getClassLoader(), new Class[]{Null.class, IPart.class}, new NullPartInvocationHandle(aClass));
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", getClass().getSimpleName() + "[", "]")
        .toString();
  }
}

class Filter1 extends Part1 {
}

class FuelFilter1 extends Filter1 {
  public static class Factory implements thinkingjava.factory.Factory<FuelFilter1> {
    @Override
    public FuelFilter1 create() {
      return new FuelFilter1();
    }
  }
}

class AirFilter1 extends Filter1 {
  public static class Factory implements thinkingjava.factory.Factory<AirFilter1> {
    @Override
    public AirFilter1 create() {
      return new AirFilter1();
    }
  }
}

class CabinAirFilter1 extends Filter1 {
  public static class Factory implements thinkingjava.factory.Factory<CabinAirFilter1> {
    @Override
    public CabinAirFilter1 create() {
      return new CabinAirFilter1();
    }
  }
}

class OilFilter1 extends Filter1 {
  public static class Factory implements thinkingjava.factory.Factory<OilFilter1> {
    @Override
    public OilFilter1 create() {
      return new OilFilter1();
    }
  }
}

class Belt1 extends Part1 {
}

class FanBelt1 extends Belt1 {
  public static class Factory implements thinkingjava.factory.Factory<FanBelt1> {
    @Override
    public FanBelt1 create() {
      return new FanBelt1();
    }
  }
}

class GeneratorBelt1 extends Belt1 {
  public static class Factory implements thinkingjava.factory.Factory<GeneratorBelt1> {
    @Override
    public GeneratorBelt1 create() {
      return new GeneratorBelt1();
    }
  }
}

class PowerSteeringBelt1 extends Belt1 {
  public static class Factory implements thinkingjava.factory.Factory<PowerSteeringBelt1> {
    @Override
    public PowerSteeringBelt1 create() {
      return new PowerSteeringBelt1();
    }
  }
}