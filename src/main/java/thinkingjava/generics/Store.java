package thinkingjava.generics;

import thinkingjava.net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author 李重辰
 * @date 2019/12/25 20:57
 */
public class Store extends ArrayList<Aisle> {
  public static void main(String[] args) {
    System.out.println(new Store(14, 5, 10));
  }

  private ArrayList<CheckoutStand> checkouts = new ArrayList<>();
  private Office office = new Office();

  public Store(int nAisles, int nShelves, int nProducts) {
    for (int i = 0; i < nAisles; i++) {
      add(new Aisle(nShelves, nProducts));
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (Aisle a : this) {
      for (Shelf s : a) {
        for (Product p : s) {
          result.append(p);
          result.append("\n");
        }
      }
    }
    return result.toString();
  }
}

class CheckoutStand {
}

class Office {
}

class Aisle extends ArrayList<Shelf> {
  public Aisle(int nShelves, int nProducts) {
    for (int i = 0; i < nShelves; i++) {
      add(new Shelf(nProducts));
    }
  }
}

class Shelf extends ArrayList<Product> {
  public Shelf(int nProducts) {
    Generators.fill(this, Product.generator, nProducts);
  }
}

class Product {
  private final int id;
  private String description;
  private double price;

  public void priceChange(double change) {
    price += change;
  }

  @Override
  public String toString() {
    return id + ": " + description + ", price: $" + price;
  }

  public Product(int id, String description, double price) {
    this.id = id;
    this.description = description;
    this.price = price;
  }

  public static Generator<Product> generator = new Generator<Product>() {
    private Random random = new Random(System.currentTimeMillis());

    @Override
    public Product next() {
      return new Product(random.nextInt(1000), "Test", Math.round(random.nextDouble() * 1000.0) + 0.99);
    }
  };
}
