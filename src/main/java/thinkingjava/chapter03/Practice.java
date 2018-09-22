package thinkingjava.chapter03;

public class Practice3_4_1 {
    public static void main(String[] args){
        for (int i=0; i<=100; i++) {
            switch (i){
                case 1:
                    System.out.println(i);
                case 2:
                    System.out.println(i);
                case 3:
                    System.out.println(i);
                case 4:
                    System.out.println(i);
                    break;
                default:
            }
            if (i==47) {
                return;
            }

        }
    }
}
