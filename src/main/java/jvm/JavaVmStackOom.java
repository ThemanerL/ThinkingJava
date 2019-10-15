package jvm;

/**
 * 创建线程导致内存溢出异常
 * VM Args: -Xss2M
 *
 * @author 李重辰
 * @date 2019/10/10 22:33
 */
public class JavaVmStackOom {

  public static void main(String[] args) {
    JavaVmStackOom oom = new JavaVmStackOom();
    oom.stackLeakByThread();
  }

  private void dontStop() {
    while (true) {

    }
  }

  private void stackLeakByThread() {
    while (true) {
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          dontStop();
        }
      });
    }
  }
}
