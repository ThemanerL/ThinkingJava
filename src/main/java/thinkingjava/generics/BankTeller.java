package thinkingjava.generics;

import thinkingjava.net.mindview.util.Generator;

import java.util.*;

/**
 * @author 李重辰
 * @date 2019/12/25 20:37
 */
public class BankTeller {
  public static void serve(Teller t, Customer c) {
    System.out.println(t + " serves " + c);
  }

  public static void main(String[] args) {
    Random random = new Random(System.currentTimeMillis());
    Queue<Customer> line = new LinkedList<>();
    Generators.fill(line, Customer.generator(), 15);
    List<Teller> tellers = new ArrayList<>();
    Generators.fill(tellers, Teller.generator(), 4);
    for (Customer c:line) {
      serve(tellers.get(random.nextInt(tellers.size())), c);
    }
  }
}

class Customer {
  private static long counter = 1;
  private final long id = counter++;

  private Customer() {
  }

  @Override
  public String toString() {
    return "{\"Customer\":{" +
        "\"id\":" + id +
        "}}";
  }

  public static Generator<Customer> generator() {
    return Customer::new;
  }
}

class Teller {
  private static long counter = 1;
  private final long id = counter++;

  private Teller() {
  }

  @Override
  public String toString() {
    return "{\"Teller\":{" +
        "\"id\":" + id +
        "}}";
  }

  public static Generator<Teller> generator() {
    return Teller::new;
  }
}