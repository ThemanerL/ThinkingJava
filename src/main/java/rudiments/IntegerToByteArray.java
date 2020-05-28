package rudiments;

import java.math.BigInteger;

/**
 * @author 李重辰
 * @date 2020/5/27 11:11
 */
public class IntegerToByteArray {
  public static void main(String[] args) {
    IntegerToByteArray integerToByteArray = new IntegerToByteArray();
    byte[] bytes = integerToByteArray.toByteArray(-12345);
    System.out.println(-12345 + " 二进制 " + Integer.toBinaryString(-12345));

    for (int i = 0; i < bytes.length; i++) {
      System.out.print(bytes[i] + " == " + Integer.toBinaryString(bytes[i]));
      System.out.println();
    }

    System.out.println(integerToByteArray.byteArrayToInteger(bytes));
    System.out.println("---------------------------------------");
    byte[] a = new byte[10];
    a[0] = -127;
    System.out.println(Integer.toBinaryString(127));
    System.out.println(Integer.toBinaryString(-127));
    System.out.println(a[0]);
    int c = a[0] & 0xff;
    System.out.println(c);
    System.out.println(Integer.toBinaryString(c));
    BigInteger bi = new BigInteger("FF", 16);
    System.out.println(bi.intValue() + "---------" + Integer.toBinaryString(bi.intValue()));
    System.out.println("-127" + Integer.toBinaryString(-127));
    System.out.println("127" + Integer.toBinaryString(127));
    System.out.println(bi.intValue() + " ---------" + Integer.toBinaryString(new BigInteger("ffffffff", 16).intValue() & 0XFF));
    System.out.println("11111111111111111111111110000001---------" + Integer.toBinaryString(new BigInteger("11111111111111111111111110000001", 2).intValue()));
    System.out.println("212---------" + Long.parseLong("11111111111111111111111111111111", 2));
    System.out.println("212---------" + Long.parseLong("11111111", 2));
    System.out.println("212---------" + Long.parseLong("10000001", 2));
  }

  private int byteArrayToInteger(byte[] bytes) {
    int result = 0;
    for (int i = 0; i < bytes.length; i++) {
      result += (bytes[i] & 0XFF) << (8 * (bytes.length - 1 - i));
    }
    return result;
  }

  private byte[] toByteArray(Integer i) {
    // 00000000 00000000 00000000 00000000
    byte[] bytes = new byte[4];
    for (int j = 0; j < bytes.length; j++) {
      bytes[j] = (byte) (i >> (8 * (bytes.length - 1 - j)));
      System.out.println(Integer.toBinaryString(bytes[j]));
    }
    return bytes;
  }

}
