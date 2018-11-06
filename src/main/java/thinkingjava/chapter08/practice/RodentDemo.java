package thinkingjava.chapter08.practice;

/**
 * @author 李重辰
 * @date 2018/10/3 0:28
 */
public class RodentDemo {
  public static void main(String[] args) {
    Rodent[] rodents = {new Mouse(), new Gerbil(), new Hamster()};
    for (Rodent s : rodents) {
      s.printSize();
      System.out.println(s.getId());
    }
  }
}

/**
 * (啮齿动物)
 */
class Rodent {

  private static int orcount = 0;
  /**
   * 这代表被创建的Rodent对象数量
   * 每创建一个Rodent对象就会将orcount的值赋给id并且将orcount++
   */
  private final int id = orcount++;

  private double size = 0.00;
  private double weight = 0.00;

  public double getSize() {
    return size;
  }

  public int getId() {
    return id;
  }

  public void setSize(double size) {
    this.size = size;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public void printSize() {
    System.out.println(getSize());
  }
}

class Mouse extends Rodent {
  @Override
  public double getSize() {
    return super.getSize() + 1.11;
  }

  @Override
  public void setSize(double size) {
    super.setSize(size);
  }

  @Override
  public double getWeight() {
    return super.getWeight() + 1.11;
  }

  @Override
  public void setWeight(double weight) {
    super.setWeight(weight);
  }
}

/**
 * 鼹鼠
 */
class Gerbil extends Rodent {
  @Override
  public double getSize() {
    return super.getSize() + 2.22;
  }

  @Override
  public void setSize(double size) {
    super.setSize(size);
  }

  @Override
  public double getWeight() {
    return super.getWeight() + 2.22;
  }

  @Override
  public void setWeight(double weight) {
    super.setWeight(weight);
  }
}

/**
 * 大颊鼠
 */
class Hamster extends Rodent {
  @Override
  public double getSize() {
    return super.getSize() + 3.33;
  }

  @Override
  public void setSize(double size) {
    super.setSize(size);
  }

  @Override
  public double getWeight() {
    return super.getWeight() + 3.33;
  }

  @Override
  public void setWeight(double weight) {
    super.setWeight(weight);
  }
}