package thinkingjava.chapter07;

/**
 * @author 李重辰
 * @date 2018/9/28 21:32
 */
public class Orc extends Villain{
    private int orcNumber;
    Orc(String name, int orcNumber){
        super(name);
        this.orcNumber = orcNumber;
    }
    public void change(String name, int orcNumber){
        setName(name);
        this.orcNumber = orcNumber;
    }

    protected void printName(){
        System.out.println("It's Orc.");
    }

    @Override
    public String toString() {
        return "Orc" + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args) {
        Orc orc = new Orc("李重辰",12);
        System.out.println(orc);
        orc.change("Joey",19);
        System.out.println(orc);
    }
}

class Villain{
    private String name;
    protected void setName(String name1){
        name = name1;
    }
    public Villain(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "I'm a Villain and my name is " + name;
    }
}
