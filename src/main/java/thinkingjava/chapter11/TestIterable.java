package thinkingjava.chapter11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 李重辰
 * @date 2018/11/21 23:01
 */
public class TestIterable {
  public static void main(String[] args) {
    ArrayList<String> all=new ArrayList<>();
    all.add("zhangsan");
    all.add("lisi");
    all.add("wangwu");
    Iterator it=all.iterator();
    // 在移除"wangwu"之后，all的Size()为2，而只是的It的Cursor已经指到了3，it的expectedModCount=3，而all的ModCount=4，
    // 因为hasNext的判断是cursor！=size即为true，此时其实已经出错了，因为游标已经大于了size，如果正常操作，游标向右滑动
    // 到size的时候hasNext就已经为false，不会进入到循环体，但是因为判断条件是不等于，所以错误的进入到了循环体内部，此时
    // 调用next方法，在方法内部进行checkForComodification()，发现Iterator的expectedModCount与List的ModCount不一致，抛出
    // 异常。

    // 在移除"list"时，移除"list"之后，迭代器的游标Cursor=2，而此时的list的size也=2，所以不进入循环体，不报异常
    // 在移除"zhangsan"时，游标指向1，而size=2，hasNext返回true，进入循环体，在checkForComodification()时候报异常

    // 注意，"zhangsan" 与 "wangwu"的情况不同在于，虽然都进入了循环体，但是“wangwu”进入是因为 Iterable的Cursor>List的size
    // 而"wangwu"是 Iterable的Cursor<List的size  假如，假如，没有经由checkForComodification()方法检验，"wangwu"情况下的
    // 调用.next()方法，会抛出NoSuchElementException异常，而"zhangsan"情况下的.next()方法会指向wangwu，而"lisi"会被跳过
    while(it.hasNext()){
      String str=(String)it.next();
      //当我把这里的lisi改成zhangsan或者wangwu的时候，运行的时候，就会报异常，但是当时lisi的时候怎么不会
      if("zhangsan".equals(str)){
        all.remove(str);
      }
    }
    //但是lisi的时候打印结果是zhansan,wangwu
    System.out.println(all);
  }

  private void testIterable(){
    List<Integer> list = new ArrayList<>( );
    int size = 5;
    for (int i = 0; i < size; i++) {
      list.add(i);
    }
    Iterator<Integer> it = list.iterator();
    Iterator<Integer> it1 = list.iterator();
    while (it.hasNext()){
      it.next();
      it.remove();
    }
    while (it1.hasNext()){
      System.out.println(it.next());
    }
    for (int i = 0; i < size; i++) {
      list.add(i);
    }
    list.clear();
    System.out.println(list);
  }
}
