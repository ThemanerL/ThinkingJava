package thinkingjava.chapter05;

/**
 * @author 李重辰
 * @date 2018/10/1 12:28
 */
public class Burrito {
    private Spiciness degree;

    private Burrito(Spiciness degree){
        this.degree = degree;
    }

    private void describe(){
        System.out.print("This Burrito is ");
        switch (degree){
            case NOT:
                System.out.println("not spicy at all.");
                break;
            case MILD:
            case MEDIUM:
                System.out.println("a little hot,");
                break;
            case HOT:
            case FLAMING:
            default:
                System.out.println("maybe too hot");
        }
    }

    public static void main(String[] args) {
        Burrito plain = new Burrito(Spiciness.NOT);
        Burrito greenChile = new Burrito(Spiciness.MEDIUM);
        Burrito jalapeno = new Burrito(Spiciness.HOT);
        plain.describe();
        greenChile.describe();
        jalapeno.describe();
    }
}
