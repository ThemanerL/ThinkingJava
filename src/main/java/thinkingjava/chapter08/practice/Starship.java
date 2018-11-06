package thinkingjava.chapter08.practice;

/**
 * @author 李重辰
 * @date 2018/10/5 19:07
 */
public class Starship {
  public static void main(String[] args) {
    P16 alertStatus = new P16();
    alertStatus = alertStatus.changeToAdd(alertStatus);
    alertStatus.performStatus();
    alertStatus = alertStatus.changeToUpdate(alertStatus);
    alertStatus.performStatus();
    alertStatus = alertStatus.changeToDelete(alertStatus);
    alertStatus.performStatus();
  }
}

class P16 {
  void performStatus() {
    System.out.println("P16.performStatus");
  }

  P16 changeToAdd(P16 status) {
    return status = new Add();
  }

  P16 changeToUpdate(P16 status) {
    return status = new Update();
  }

  P16 changeToDelete(P16 status) {
    return status = new Delete();
  }
}

class Add extends P16 {
  @Override
  void performStatus() {
    System.out.println("Add.performStatus");
  }
}

class Update extends P16 {
  @Override
  void performStatus() {
    System.out.println("Update.performStatus");
  }
}

class Delete extends P16 {
  @Override
  void performStatus() {
    System.out.println("Delete.performStatus");
  }
}