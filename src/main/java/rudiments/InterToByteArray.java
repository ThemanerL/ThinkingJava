package rudiments;

/**
 * int与byte数组之间的转化
 *
 * @author 李重辰
 * @date 2020/5/13 16:01
 */
public class InterToByteArray {
  static int INT_BINARY_LENGTH = 4;

  public static void main(String[] args) {
    byte[] bytes = InterToByteArray.intToByteArray(-12345);
    for (byte b : bytes) {
      System.out.print(b);
    }
    System.out.println();
    System.out.println(InterToByteArray.byteArrayToInt(bytes));
  }

  public static byte[] intToByteArray(int source) {
    byte[] bytes = new byte[INT_BINARY_LENGTH];
    for (int j = 0; j < INT_BINARY_LENGTH; j++) {
      bytes[INT_BINARY_LENGTH - j - 1] = (byte) (source >> (8 * j));
    }
    return bytes;
  }

  public static int byteArrayToInt(byte[] source) {
    int result = 0;
    for (int j = 0; j < INT_BINARY_LENGTH; j++) {
      result += (source[INT_BINARY_LENGTH - j - 1] & 0xff) << (8 * j);
    }
    return result;
  }

}
