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
                greenhouseControls.new BlowerOn(1000),
                greenhouseControls.new BlowerOff(1200),
                greenhouseControls.new ThermostatDay(1400)
        };
        greenhouseControls.addEvent(greenhouseControls.new Restart(200, events));
        ///如果提供了命令行参数,系统会以它作为毫秒数,决定什么时候终止程序
        //更好的方式是从文件中读取需要的事件
//        if(args.length == 1){
//            greenhouseControls.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
//        }


        //这是测试的时候使用的数据,也就是没有指定命令行参数而是在这里把停止的条件写死
         if(args.length == 0){
        greenhouseControls.addEvent(new GreenhouseControls.Terminate(1L));
        }
        greenhouseControls.run();
    }
}
