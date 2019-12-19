package thinkingjava.typeinfo;

import thinkingjava.factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

/**
 * @author 李重辰
 * @date 2019/12/19 11:39
 */
public class RegisteredFactories {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println(Part.createRandom());
    }
  }
}

class Part {
  @Override
  public String toString() {
    return new StringJoiner(", ", getClass().getSimpleName() + "[", "]")
        .toString();
  }

  static List<Factory<? extends Part>> partFactories = new ArrayList<>();

  private static Random rand = new Random(System.currentTimeMillis());

  static Part createRandom() {
    int n = rand.nextInt(partFactories.size());
    return partFactories.get(n).create();
  }

  static {
    partFactories.add(new FuelFilter.Factory());
    partFactories.add(new AirFilter.Factory());
    partFactories.add(new CabinAirFilter.Factory());
    partFactories.add(new OilFilter.Factory());
    partFactories.add(new FanBelt.Factory());
    partFactories.add(new PowerSteeringBelt.Factory());
    partFactories.add(new GeneratorBelt.Factory());
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