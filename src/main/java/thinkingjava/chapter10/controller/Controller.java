package thinkingjava.chapter10.controller;

import java.util.*;

/**
 * 此时你明不知道AbstractEvent的实现类到底做了什么。这正是设计的关键所在，“使变化的事物与不变的事物相互分离”。
 * @author 李重辰
 * @date 2018/11/1 15:24
 */
public class Controller {
    private List<AbstractEvent> eventList = new ArrayList<AbstractEvent>();

    public void addEvent(AbstractEvent c) {
        eventList.add(c);
    }

    public void run() {
        while (eventList.size() > 0) {
            for (AbstractEvent event : eventList) {
                if (event.ready()) {
                    System.out.println(event);
                    event.action();
                    eventList.remove(event);
                }
            }
        }
    }
}
