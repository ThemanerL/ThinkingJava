package thinkingjava.chapter07.practice;

/**
 * @author 李重辰
 * @date 2018/9/28 17:29
 */
public class P17 extends Origin {

  private void myName(String firstName, String midName, String lastName, int age) {
    myName(firstName, midName, lastName);
    System.out.print(" " + age);
  }

  public static void main(String[] args) {
    P17 p17 = new P17();
    p17.myName("李");
    System.out.println();
    p17.myName("李", "重");
    System.out.println();
    p17.myName("李", "重", "辰");
    System.out.println();
    p17.myName("李", "重", "辰", 18);

    P17 p18 = new P17();
    p18.myName("李");
    System.out.println();
    p18.myName("李", "重");
    System.out.println();
    p18.myName("李", "重", "辰");
    System.out.println();
    p18.myName("重", "辰", "李", 81);
  }
}

class Origin {
  void myName(String firstName) {
    System.out.print("My name is " + firstName);
  }

  void myName(String firstName, String midName) {
    myName(firstName);
    System.out.print(midName);
  }

  void myName(String firstName, String midName, String lastName) {
    myName(firstName, midName);
    System.out.print(lastName);
  }
}
