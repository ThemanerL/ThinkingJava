1. 深刻理解游标与索引的概念
   ![CursorImg](https://thinkingjava-md-1257967443.cos.ap-guangzhou.myqcloud.com/Cursor%E7%A4%BA%E4%BE%8B%E5%9B%BE.png)  
   注意：在Iterator.hasNext()的时候，游标指向0，此时index为-1;Iterator.next()指向索引“零”；在执行一次next()之后，游标向右移动一位，游标为1，next()指向索引“一”，此时previousIndex()即上一个索引“零”