package thinkingjava.chapter10.controller;

/**
 * @author 李重辰
 * @date 2018/11/1 16:44
 */
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls greenhouseControls = new GreenhouseControls();
        greenhouseControls.addEvent(greenhouseControls.new Bell(999));
        AbstractEvent[] events = {
                greenhouseControls.new ThermostatNight(0),
                greenhouseControls.new LightOn(200),
                greenhouseControls.new LightOff(400),
                greenhouseControls.new WaterOn(600),
                greenhouseControls.new WaterOff(800),
                greenhouseControls.new ThermostatDay(1400)
        };
        greenhouseControls.addEvent(greenhouseControls.new Restart(200, events));
        if(args.length == 1){
            greenhouseControls.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
        }
        greenhouseControls.run();
    }
}
