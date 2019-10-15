package jvm;

/**
 * 虚拟机栈和本地方法栈OOM测试
 * VM Args: -Xss128k
 *
 * @author 李重辰
 * @date 2019/10/10 20:37
 */
public class JavaVmStackSOF {

  private int stackLength = 1;

  public static void main(String[] args) {
    JavaVmStackSOF oom = new JavaVmStackSOF();
    try {
      oom.stackLeak();
    } catch (Throwable e) {
      System.out.println("stack length:" + oom.stackLength);
      throw e;
    }
  }

  private void stackLeak() {
    stackLength++;
    stackLeak();
  }
}
