1. 深刻理解游标与索引的概念  
   ![CursorImg](https://thinkingjava-md-1257967443.cos.ap-guangzhou.myqcloud.com/Cursor%E7%A4%BA%E4%BE%8B%E5%9B%BE.png)  
   注意：在Iterator.hasNext()的时候，游标指向0，此时index为-1;Iterator.next()指向索引“零”；在执行一次next()之后，游标
   向右移动一位，游标为1，next()指向索引“一”，此时previousIndex()即上一个索引“零”  
2. 实现Iterable接口的类，可以通过foreach语句去遍历.而实现Iterator的类，可以构建迭代器.
使用Iterator类去遍历。想要支持foreach遍历的功能，必须实现Iterable，这个类有一个方法Iterator()，返回一个Iterator对象，在实际使
用中，通常返回一个实现Iterator接口的匿名内部类  
3. 在创建了迭代器之后就不能再修改原Collection的值，否则会报告ConcurrentModificationException 异常，除非通过迭代器自身从结
构上修改Collection，否则一定会报这个异常(modCount（记录了对集合修改的次数）的值不等于expectedModCount（通过迭代器对集合修
改的次数）的值会抛异常)。Iterator会创建一个单链索引表指向原来的对象，当原来的对象发生改变时，这个索引表不会被同步改变，
所以当Iterator的cursor移动就会找不到元素，因为，按照fail-Fast机制，一旦原对象被修改，则立刻抛出ConcurrentModificationException
异常 [via.yycat](http://www.cnblogs.com/YYCat/p/4675084.html)
4. Q:[迭代器删除元素？](http://bbs.itheima.com/forum.php?mod=viewthread&tid=26270&mobile=1)   
A:
    1. 在移除"lisi"之后，迭代器的游标Cursor=2，而此时的List的size也=2，所以不进入循环体，不报异常
    2. 在移除"zhangsan"时，游标指向1，而size=2，hasNext返回true，进入循环体，在checkForComodification()时候报异常
    3. 在移除"wangwu"之后，List的Size()为2，而只是的it的Cursor已经指到了3，it的expectedModCount=3，而List的ModCount=4，
    因为hasNext的判断是cursor!=size即为true，此时其实已经出错了，因为游标已经大于了size，如果正常操作，游标向右滑动
    到size的时候hasNext就已经为false，不会进入到循环体，但是因为hasNext()的判断条件是size不等于cursor，所以错误的进入到
    了循环体内部，此时调用next方法，在方法内部进行checkForComodification()，发现Iterator的expectedModCount与List的ModCount
    不一致，抛出异常。
    4. 注意，"zhangsan" 与 "wangwu"的情况不同在于，虽然都进入了循环体，但是“wangwu”进入是因为 Iterable的Cursor>List的size
    而"wangwu"是 Iterable的Cursor<List的size() **假如**，没有经由checkForComodification()方法检验，"wangwu"情况下的
    调用.next()方法，会抛出NoSuchElementException异常，而"zhangsan"情况下的.next()方法会指向wangwu，而"lisi"会被跳过