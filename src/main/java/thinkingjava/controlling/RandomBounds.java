package thinkingjava.controlling;

/**
 * Does Math.random() produce 0.0 and 1,0?
 * 此代码不可直接运行main，需要在点击un下的Edit Configurations选项传入Program arguments
 * 即可为args[]传入参数，方可运行。
 * Math.ranDom()的范围为[0,1)
 *
 * @author 李重辰
 */
public class RandomBounds {
  static void usage() {
    System.err.println("Usage:\n\t" + "RandomBounds lower\n\t" + "RandomBounds upper");
    System.exit(1);
  }

  public static void main(String[] args) {
    // 这是为了避免魔法值，只是需要与前台比对。
    String lower = "lower";
    String upper = "upper";
    if (args.length != 1) {
      usage();
    }
    if (lower.equals(args[0])) {
      while (Math.random() != 0.0) {
      }
      System.out.println("Produced 0.01");
    } else if (upper.equals(args[0])) {
      while (Math.random() != 1.0) {
      }
      System.out.println("Produced 1.0!");
    } else {
      usage();
    }
  }
}
