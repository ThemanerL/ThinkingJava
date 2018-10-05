package thinkingjava.chapter08;

/**
 * @author 李重辰
 * @date 2018/10/4 11:28
 */
public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared0 = new Shared();
        Shared shared1 = new Shared();
        Composing[] composings = {
                new Composing(shared0),new Composing(shared0),new Composing(shared1),new Composing(shared0),new Composing(shared0)
        };
        for (Composing c: composings) {
            c.dispose();
        }
    }

}

class Shared{
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;

    Shared() {
        System.out.println("Creating " + this);
    }

    void addRef(){
        refcount++;
    }

    /**
     * (--refcount == 0)先自减,减完之后看再判断==0.即在Shared对象只被引用一次时进行dispose操作.
     * (refcount-- == 0)先判断==0,判断完之后再自减
     */
    void dispose(){
        if (--refcount == 0){
            System.out.println("Disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared{" + id + '}';
    }
}

class Composing{
    private Shared shared;
    private static long counter;
    private final long id = counter++;

    Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    void dispose(){
        System.out.println("Disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing{" + id +
                '}';
    }
}
