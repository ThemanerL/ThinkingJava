package jvm;

/**
 * 此代码演示了两点
 * 1. 对象可以在被GC时自我拯救。
 * 2. 这种自救机会只有一次，因为一个对象的finalize()对象最多只会被系统自动调用一次
 *
 * @author 李重辰
 * @date 2019/10/15 22:35
 */
public class FinalizeEscapeGc {
  private static FinalizeEscapeGc SAVE_HOOK = null;

  public static void main(String[] args) throws InterruptedException {
    SAVE_HOOK = new FinalizeEscapeGc();

    // 对象第一次拯救自己
    SAVE_HOOK = null;
    System.gc();
    // 因为finalize()方法优先级很低，所以暂停0.5秒等待它
    Thread.sleep(500);
    if (SAVE_HOOK != null) {
      SAVE_HOOK.isAlive();
    } else {
      System.out.println("no, i am dead :(");
    }

    // 下面这段代码与上面完全相同，但是这是自救确失败了
    SAVE_HOOK = null;
    System.gc();
    // 因为finalize()方法优先级很低，所以暂停0.5秒等待它
    Thread.sleep(500);
    if (SAVE_HOOK != null) {
      SAVE_HOOK.isAlive();
    } else {
      System.out.println("no, i am dead :(");
    }
  }

  private void isAlive() {
    System.out.println("yes, i am still alive :)");
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("finalize method executed!");
    FinalizeEscapeGc.SAVE_HOOK = this;
  }
}
