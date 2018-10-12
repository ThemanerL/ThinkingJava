package thinkingjava.chapter09;

/**
 * @author 李重辰
 * @date 2018/10/12 11:39
 */
public class HorrorShow {
    static  void 
}

interface Monster{
    void menace();
}

interface DangerousMonster extends Monster{
    void destroy();
}

/**
 * 致命、致死
 */
interface Lethal{
    void kill();
}

class DragonZilla implements DangerousMonster{
    public void menace() {

    }

    public void destroy() {

    }
}

interface Vampire extends DangerousMonster,Lethal{
    void drinkBlood();
}

class VeryBadVampire implements Vampire{
    public void menace() {

    }

    public void destroy() {

    }

    public void kill() {

    }

    public void drinkBlood() {

    }
}

