package thinkingjava.chapter07;

/**
 * SpaceShip包含SpaceShipControls，与此同时，SpaceShipControls的所有方法都在SpaceShip中暴露出来了。
 * @author 李重辰
 * @date 2018/9/28 12:22
 */
public class SpaceShip extends SpaceShipControls {
    private String name;

    public SpaceShip(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        SpaceShip protector = new SpaceShip("NSEA Protector");
        protector.forward(100);
    }
}

class SpaceShipControls {
    void up(int velocity) {
    }

    void down(int celocity) {
    }

    void left(int velocity) {
    }

    void right(int celocity) {
    }

    void forward(int celocity) {
    }

    void back(int velocity) {
    }

    void turboBoost(int celocity) {
    }
}
