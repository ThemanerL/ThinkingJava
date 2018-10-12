package thinkingjava.chapter09;

/**
 * 一般情况下，只可以将extends用于单一类，但是可以引用多个基类接口，就像所看到的，只需用逗号将接口名一一分隔开即可。
 * @author 李重辰
 * @date 2018/10/12 11:39
 */
public class HorrorShow {
    static  void u(Monster b){
        b.menace();
    }

    static void v(DangerousMonster d){
        d.menace();
        d.destroy();
    }

    static void w(Lethal l){
        l.kill();
    }

    public static void main(String[] args){
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        u(vlad);
        u(vlad);
    }
}

interface Monster{
    /**
     * 威胁
     */
    void menace();
}

interface DangerousMonster extends Monster{
    /**
     * 毁灭
     */
    void destroy();
}


interface Lethal{
    /**
     * 致命、致死
     */
    void kill();
}

/**
 * 叫吉拉的龙
 */
class DragonZilla implements DangerousMonster{

    public void menace() {

    }

    public void destroy() {

    }
}

/**
 * 吸血鬼
 */
interface Vampire extends DangerousMonster,Lethal{
    /**
     * 吸血鬼在喝血啦
     */
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

