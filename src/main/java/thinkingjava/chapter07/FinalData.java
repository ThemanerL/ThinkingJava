package thinkingjava.chapter07;

import java.util.Random;

/**
 * 带有恒定初始值的final static 基本类型全用大写字母命名，字与字之间用下划线隔开。
 * 注意:不能认定数据是final的就认为在编译时值可知。final修饰的基本类型代表着值被初始化之后值不能被改变，引用类型代表着不能再指向一个新的对象；static：在类第一次加载时定义
 *
 * @author 李重辰
 * @date 2018/9/29 20:10
 */
public class FinalData {
  private static Random rand = new Random(47);
  private String id;

  private FinalData(String id) {
    this.id = id;
  }

  /**
   * compile-time constants
   */
  public final int valueOne = 9;
  private static final int VALUE_TWO = 99;
  /**
   * Typical public constant
   * 经典的常量定义，定义为public，可以被运用于包外；定义为static，强调只有一份；定义为final，说明是一个常量
   */
  public static final int VALUE_THREE = 39;
  /**
   * Cannot be compile-time constants
   */
  private final int i4 = rand.nextInt(20);
  private final int INT_5 = rand.nextInt(20);
  private Value v1 = new Value(11);
  private final Value v2 = new Value(22);
  private static final Value VAL_3 = new Value(33);
  /**
   * String 本身就是不可变字符串
   */
  private static final String S1 = "Test String";

  /**
   * Arrays
   */
  private final int[] a = {1, 2, 3, 4, 5, 6};

  @Override
  public String toString() {
    return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
  }

  public static void main(String[] args) {
    FinalData finalData1 = new FinalData("finalData1");
    // finalData1.valueOne++; //Final cannot change value
    finalData1.v2.i++;
    finalData1.v1 = new Value(9);
    for (int i = 0; i < finalData1.a.length; i++) {
      finalData1.a[i]++;
    }
    System.out.println(finalData1);
    System.out.println(FinalData.S1);
    System.out.println("Creating a new FinalData");
    FinalData finalData2 = new FinalData("finalData2");
    System.out.println(finalData1);
    System.out.println(finalData2);

  }

}

class Value {
  int i;

  Value(int i) {
    this.i = i;
  }
}
