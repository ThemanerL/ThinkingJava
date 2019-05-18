package thinkingjava.innerclasses.controller;

/**
 * 考虑到此控制框架的特定实现:控制温室的运作：控制灯光，水等等，每个行为都是完全不同的，控制框架的设计使得分离这些不同的代码非常容易，
 *
 * @author 李重辰
 * @date 2018/11/1 15:41
 */
public class GreenhouseControls extends Controller {
  private boolean light = false;
  private boolean water = false;
  private String thermostat = "Day";
  private boolean roll = false;

  public static class Terminate extends AbstractEvent {
    public Terminate(long delayTime) {
      super(delayTime);
    }

    @Override
    public void action() {
      System.exit(0);
    }

    @Override
    public String toString() {
      return "Terminating";
    }
  }

  public class LightOn extends AbstractEvent {
    public LightOn(long delayTime) {
      super(delayTime);
    }

    @Override
    public void action() {
      light = true;
    }

    @Override
    public String toString() {
      return "Light is on";
    }
  }

  public class LightOff extends AbstractEvent {
    public LightOff(long delayTime) {
      super(delayTime);
    }

    @Override
    public void action() {
      light = false;
    }

    @Override
    public String toString() {
      return "Light if off";
    }
  }

  public class WaterOn extends AbstractEvent {
    public WaterOn(long delayTime) {
      super(delayTime);
    }

    @Override
    public void action() {
      water = true;
    }

    @Override
    public String toString() {
      return "Greenhouse water is on " + water;
    }
  }

  public class WaterOff extends AbstractEvent {
    public WaterOff(long delayTime) {
      super(delayTime);
    }

    @Override
    public void action() {
      water = false;
    }

    @Override
    public String toString() {
      return "Greenhouse water is off " + water;
    }
  }

  public class ThermostatNight extends AbstractEvent {
    public ThermostatNight(long delayTime) {
      super(delayTime);
    }

    @Override
    public void action() {
      thermostat = "Night";
    }

    @Override
    public String toString() {
      return "Thermostat on night setting";
    }
  }

  public class ThermostatDay extends AbstractEvent {
    public ThermostatDay(long delayTime) {
      super(delayTime);
    }

    @Override
    public void action() {
      thermostat = "Day";
    }

    @Override
    public String toString() {
      return "Thermostat on day setting";
    }
  }

  public class Bell extends AbstractEvent {
    public Bell(long delayTime) {
      super(delayTime);
    }

    @Override
    public void action() {
      addEvent(new Bell(delayTime));
    }

    @Override
    public String toString() {
      return "Bing！";
    }
  }

  public class BlowerOn extends AbstractEvent {
    public BlowerOn(long delayTime) {
      super(delayTime);
    }

    @Override
    public void action() {
      roll = true;
    }

    @Override
    public String toString() {
      return "The blower open";
    }
  }

  public class BlowerOff extends AbstractEvent {
    public BlowerOff(long delayTime) {
      super(delayTime);
    }

    @Override
    public void action() {
      roll = false;
    }

    @Override
    public String toString() {
      return "The blower close";
    }
  }

  public class Restart extends AbstractEvent {
    private AbstractEvent[] abstractEvents;

    public Restart(long delayTime, AbstractEvent[] abstractEvents1ist) {
      super(delayTime);
      this.abstractEvents = abstractEvents1ist;
      for (AbstractEvent event : abstractEvents) {
        addEvent(event);
      }

    }

    @Override
    public void action() {
      for (AbstractEvent event : abstractEvents) {
        event.start();
        addEvent(event);
      }
      start();
      addEvent(this);
    }

    @Override
    public String toString() {
      return "Restarting System";
    }
  }
}
