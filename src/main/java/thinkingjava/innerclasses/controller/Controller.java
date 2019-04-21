package thinkingjava.innerclasses.controller;

import java.util.*;

/**
 * 此时你明不知道AbstractEvent的实现类到底做了什么。这正是设计的关键所在，“使变化的事物与不变的事物相互分离”。
 * 此处要注意的是,在使用foreach\迭代集合的过程中不能对集合进行修改,只能修改一个元素.涉及到使用list本身的remove和迭代器的
 * remove两种不同的操作,具体的在集合那一张细细研究阅读源码.
 *
 * objectsholding P13
 * 2018/11/11修改
 *
 * @author 李重辰
 * @date 2018/11/1 15:24
 */
class Controller {
  private LinkedList<AbstractEvent> eventList = new LinkedList<AbstractEvent>();

  void addEvent(AbstractEvent c) {
    eventList.add(c);
  }

  void run() {
    ListIterator<AbstractEvent> iterator = eventList.listIterator();
    while(iterator.hasNext()){
      AbstractEvent event = iterator.next();
      if (event.ready()){
          System.out.println(event);
          event.action();
          eventList.remove(event);
      }
    }

/// 修改前版本
//    while (eventList.size() > 0) {
//      //这个Copy的操作非常关键Make a copy so you're not modifying the list while you're selecting the elements in it
//      for (AbstractEvent event : new ArrayList<AbstractEvent>(eventList)) {
//        if (event.ready()) {
//          System.out.println(event);
//          event.action();
//          eventList.remove(event);
//        }
//      }
//    }
  }
}
