package thinkingjava.typeinfo.practice;

import thinkingjava.net.mindview.util.TypeCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

/**
 * A constructor is a kind of factory method. Modify
 * RegisteredFactories.java so that instead of using an explicit factory, the class object is
 * stored in the List, and new Instance( ) is used to create each object.
 *
 * @author 李重辰
 * @date 2019/12/19 11:39
 */
public class P14 {
  public static void main(String[] args) {
    TypeCounter counter = new TypeCounter(Part.class);
    for (int i = 0; i < 20; i++) {
      Part part = Part.createRandom();
      assert part != null;
      counter.count(part);
    }
    System.out.println(counter);
  }
}

class Part {
  @Override
  public String toString() {
    return new StringJoiner(", ", getClass().getSimpleName() + "[", "]")
        .toString();
  }

  static List<Class<? extends Part>> partFactories = new ArrayList<>();

  private static Random rand = new Random(System.currentTimeMillis());

  static Part createRandom() {
    int n = rand.nextInt(partFactories.size());
    try {
      return partFactories.get(n).newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  static {
    partFactories.add(FuelFilter.class);
    partFactories.add(AirFilter.class);
    partFactories.add(CabinAirFilter.class);
    partFactories.add(OilFilter.class);
    partFactories.add(FanBelt.class);
    partFactories.add(PowerSteeringBelt.class);
    partFactories.add(GeneratorBelt.class);
  }
}

class Filter extends Part {
}

class FuelFilter extends Filter {
  public static class Factory implements thinkingjava.factory.Factory<FuelFilter> {
    @Override
    public FuelFilter create() {
      return new FuelFilter();
    }
  }
}

class AirFilter extends Filter {
  public static class Factory implements thinkingjava.factory.Factory<AirFilter> {
    @Override
    public AirFilter create() {
      return new AirFilter();
    }
  }
}

class CabinAirFilter extends Filter {
  public static class Factory implements thinkingjava.factory.Factory<CabinAirFilter> {
    @Override
    public CabinAirFilter create() {
      return new CabinAirFilter();
    }
  }
}

class OilFilter extends Filter {
  public static class Factory implements thinkingjava.factory.Factory<OilFilter> {
    @Override
    public OilFilter create() {
      return new OilFilter();
    }
  }
}

class Belt extends Part {
}

class FanBelt extends Belt {
  public static class Factory implements thinkingjava.factory.Factory<FanBelt> {
    @Override
    public FanBelt create() {
      return new FanBelt();
    }
  }
}

class GeneratorBelt extends Belt {
  public static class Factory implements thinkingjava.factory.Factory<GeneratorBelt> {
    @Override
    public GeneratorBelt create() {
      return new GeneratorBelt();
    }
  }
}

class PowerSteeringBelt extends Belt {
  public static class Factory implements thinkingjava.factory.Factory<PowerSteeringBelt> {
    @Override
    public PowerSteeringBelt create() {
      return new PowerSteeringBelt();
    }
  }
}