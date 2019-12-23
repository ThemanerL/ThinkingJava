package thinkingjava.typeinfo.practice;

import thinkingjava.net.mindview.util.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

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
      Class<? extends IPart> random = IPart.createRandom();
      Object o = Proxy.newProxyInstance(P24.class.getClassLoader(), new Class[]{Null.class}, new NullPartInvocationHandle(random));
      System.out.println(o);
    }
  }
}

class NullPartInvocationHandle implements InvocationHandler{

  NullPart proxied = new NullPart();

  public NullPartInvocationHandle(Class<? extends IPart> c) {
    proxied.setClassName(c.getSimpleName());
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) {
    try {
      return method.invoke(proxied,args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static class NullPart extends IPart implements Null {
    String className;

    public void setClassName(String className) {
      this.className = className;
    }

    @Override
    public String toString() {
      return "Null Object" + className;
    }
  }
}

class IPart {

  @Override
  public String toString() {
    return new StringJoiner(", ", getClass().getSimpleName() + "[", "]")
        .toString();
  }

  static List<Class<? extends IPart>> partFactories = new ArrayList<>();

  private static Random rand = new Random(System.currentTimeMillis());

  static Class<? extends IPart> createRandom() {
    int n = rand.nextInt(partFactories.size());
    return partFactories.get(n);
  }

  static {
    partFactories.add(FuelFilter1.class);
    partFactories.add(AirFilter1.class);
    partFactories.add(CabinAirFilter1.class);
    partFactories.add(OilFilter1.class);
    partFactories.add(FanBelt1.class);
    partFactories.add(PowerSteeringBelt1.class);
    partFactories.add(GeneratorBelt1.class);
  }
}

class Filter1 extends IPart {
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

class Belt1 extends IPart {
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