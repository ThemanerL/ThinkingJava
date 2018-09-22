package thinkingjava.chapter03;
/**
 * @author  李重辰
 */
public class Practice {
    public static void main(String[] args){
        for (int i=0; i<=100; i++) {
            switch (i){
                case 1:
                    System.out.println(i);
                    break;
                case 2:
                    System.out.println(i);
                    break;
                case 3:
                    System.out.println(i);
                    break;
                case 4:
                    System.out.println(i);
                    break;
                default:
                    break;
            }
            if (i==47) {
                return;
            }

        }
    }
}
