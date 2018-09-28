package thinkingjava.chapter03;

/**
 * @author 李重辰
 */
public class VowelsAndConsonants {
    public static void main(String[] args) {
        int loopLength = 100;
        for (int i = 0; i < loopLength; i++) {
            char c = (char) (Math.random() * 26 + 'a');
            System.out.println(c + ": ");
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("vowel");
                    break;
                case 'y':
                case 'w':
                    System.out.println("Sometimes a vowel");
                    break;
                default:
                    System.out.println("consonant");
            }
        }
    }
}
