package thinkingjava.chapter10;

import sun.security.krb5.internal.crypto.Des;

/**
 * 嵌套类，嵌套类的被关键字Static修饰。
 * 1）要创建嵌套类对象并不需要外部类对象
 * 2）不能从嵌套类的对象中访问非静态的外部类
 *
 * @author 李重辰
 * @date 2018/10/30 20:36
 */
public class Parcel11 {
  private static class ParcelContents implements Contents {
    private int i = 11;

    @Override
    public int value() {
      return i;
    }
  }

  class Practice18 {
    public Practice18() {
      System.out.println("Pactice18.Pactice18");
    }

    class Practice19 {
      public Practice19() {
        System.out.println("Practice19.Practice19");
      }
    }
  }


  protected static class ParcelDestination implements Destination {
    private String label;

    private ParcelDestination(String label) {
      this.label = label;
    }

    @Override
    public String readLabel() {
      return label;
    }

    public static void f() {
    }

    static int x = 10;

    static class AnotherLevel {
      public static void f() {
      }

      static int x = 10;
    }
  }

  private static Destination destination(String s) {
    return new ParcelDestination(s);
  }

  private static Contents contents() {
    return new ParcelContents();
  }

  public static void main(String[] args) {
    Contents contents = contents();
    Destination destination = destination("ThemanerL");

    Parcel11 parcel11 = new Parcel11();
    Parcel11.Practice18 pactice18 = parcel11.new Practice18();
  }
}
