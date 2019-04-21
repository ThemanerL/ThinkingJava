package thinkingjava.innerclasses;

/**
 * 在任意作用域内嵌入一个内部类
 *
 * @author 李重辰
 * @date 2018/10/22 20:00
 */
public class Parcel6 {
  private void internalTracking(boolean b) {
    if (b) {
      class TrackingSlip {
        private String id;

        private TrackingSlip(String s) {
          id = s;
        }

        private String getSlip() {
          return id;
        }
      }
      TrackingSlip ts = new TrackingSlip("slip");
      String s = ts.getSlip();
    }
    ////不能在作用域外声明
    //TrackingSlip ts = new TrackingSlip("s");
  }

  public void track() {
    internalTracking(true);
  }

  public static void main(String[] args) {
    Parcel6 parcel6 = new Parcel6();
    parcel6.track();
  }
}
