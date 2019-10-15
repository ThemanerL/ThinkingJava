package jvm;

/**
 * 引用计数算法的缺陷
 *
 * @author 李重辰
 * @date 2019/10/10 23:14
 */
public class ReferenceCountingGc {
  public Object instance = null;

  public static final int ONE_MB = 1024*1024;

  /**
   * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
   */
  private byte[] bigSize = new byte[2 * ONE_MB];

  public static void main(String[] args){
    ReferenceCountingGc objA = new ReferenceCountingGc();
    ReferenceCountingGc objB = new ReferenceCountingGc();
    objA.instance = objB;
    objB.instance = objA;

    objA = null;
    objB = null;

    // 假设在车行发生GC，objA和objB能否被收回？
    System.gc();
    System.out.println("_");
  }
}
