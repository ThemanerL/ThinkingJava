package thinkingjava.generics;

import java.awt.*;

/**
 * @author 李重辰
 * @date 2019/12/30 13:49
 */
public class BasicBounds {
  public static void main(String[] args) {
    Solid<Bounded> solid = new Solid<>(new Bounded());
    solid.color();
    solid.getY();
    solid.weight();
  }
}

interface HasColor {
  /**
   * 就返回颜色呗
   *
   * @return 颜色
   */
  java.awt.Color getColor();
}

class Colored<T extends HasColor> {
  T item;

  Colored(T item) {
    this.item = item;
  }

  T getItem() {
    return item;
  }

  // The bound allows you to call a method:
  java.awt.Color color() {
    return item.getColor();
  }
}

class Dimension {
  public int x, y, z;
}

class ColoredDimension<T extends Dimension & HasColor> {
  T item;

  ColoredDimension(T item) {
    this.item = item;
  }

  T getItem() {
    return item;
  }

  java.awt.Color color() {
    return item.getColor();
  }

  int getX() {
    return item.x;
  }

  int getY() {
    return item.y;
  }

  int getZ() {
    return item.z;
  }
}

interface Weight {
  /**
   * 重量
   *
   * @return 重量
   */
  int weight();
}

class Solid<T extends Dimension & HasColor & Weight> {
  T item;

  Solid(T item) {
    this.item = item;
  }

  T getItem() {
    return item;
  }

  java.awt.Color color() {
    return item.getColor();
  }

  int getX() {
    return item.x;
  }

  int getY() {
    return item.y;
  }

  int getZ() {
    return item.z;
  }

  int weight() {
    return item.weight();
  }
}

class Bounded extends Dimension implements HasColor, Weight {
  @Override
  public java.awt.Color getColor() {
    return Color.BLACK;
  }

  @Override
  public int weight() {
    return 0;
  }
}