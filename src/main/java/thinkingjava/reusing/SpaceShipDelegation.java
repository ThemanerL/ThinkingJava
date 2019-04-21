package thinkingjava.reusing;

/**
 * 使用代理方法转递给了底层的controls对象，而其接口由此也就与使用继承得到的接口相同了。
 * 但是当我们使用代理时可以拥有更多的控制力，因为我们可以选择只提供在成员对象的方法的某个子集。
 *
 * @author 李重辰
 * @date 2018/9/28 12:30
 */
public class SpaceShipDelegation {
  private String name;
  private SpaceShipControls controls = new SpaceShipControls();

  public SpaceShipDelegation(String name) {
    this.name = name;
  }

  /**
   * DelegationMethod
   */
  public void back(int velocity) {
    controls.back(velocity);
  }

  public void forward(int velocity) {
    controls.forward(velocity);
  }

  public void up(int velocity) {
    controls.up(velocity);
  }

  public void down(int velocity) {
    controls.down(velocity);
  }

  public void turboBoost(int velocity) {
    controls.back(velocity);
  }

  public void left(int velocity) {
    controls.left(velocity);
  }

  public void right(int velocity) {
    controls.right(velocity);
  }

  public static void main(String[] args) {
    SpaceShipDelegation protector = new SpaceShipDelegation("NSEA protector");
    protector.forward(100);
  }
}
