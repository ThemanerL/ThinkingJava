package thinkingjava.chapter03;
/**
 * @author  李重辰
 */
public class IfElseReturn {
    static int test(int testval, int target){
        int result = 0;
        if (testval>target) {
            result = -1;
        } else if (testval<target) {
            result = 1;
        } else {
            result = 0;
        }
        return result;
    }

    static int test2(int testval, int target){
        if (testval>target) {
            return -1;
        }
        if (testval<target) {
            return 1;
        }
        return 0;
    }

    public static void main (String[] args){
        double r = 0;
        while (r<0.99d){
            r = Math.random();
            System.out.println(r);
        }
    }
}
