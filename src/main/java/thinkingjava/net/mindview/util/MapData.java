package thinkingjava.net.mindview.util;

import java.util.LinkedHashMap;

/**
 * A Map filled with data using a generator object.
 *
 * @param <K>
 * @param <V>
 * @author Administrator
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {
  /**
   * A single Pair Generator:
   */
  public MapData(Generator<Pair<K, V>> gen, int quantity) {
    for (int i = 0; i < quantity; i++) {
      Pair<K, V> p = gen.next();
      put(p.key, p.value);
    }
  }

  /**
   * Two separate Generators:
   *
   * @param genK
   * @param genV
   * @param quantity
   */
  public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
    for (int i = 0; i < quantity; i++) {
      put(genK.next(), genV.next());
    }
  }

  /**
   * A key Generator and a single value:
   *
   * @param genK
   * @param value
   * @param quantity
   */
  public MapData(Generator<K> genK, V value, int quantity) {
    for (int i = 0; i < quantity; i++) {
      put(genK.next(), value);
    }
  }

  /**
   * An Iterable and a value Generator:
   *
   * @param genK
   * @param genV
   */
  public MapData(Iterable<K> genK, Generator<V> genV) {
    for (K key : genK) {
      put(key, genV.next());
    }
  }

  /**
   * An Iterable and a single value:
   *
   * @param genK
   * @param value
   */
  public MapData(Iterable<K> genK, V value) {
    for (K key : genK) {
      put(key, value);
    }
  }

  /**
   * Generic convenience methods:
   *
   * @param gen
   * @param quantity
   * @param <K>
   * @param <V>
   * @return
   */
  public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity) {
    return new MapData<K, V>(gen, quantity);
  }

  public static <K, V> MapData<K, V> map(Generator<K> genK, Generator<V> genV, int quantity) {
    return new MapData<K, V>(genK, genV, quantity);
  }

  public static <K, V> MapData<K, V> map(Generator<K> genK, V value, int quantity) {
    return new MapData<K, V>(genK, value, quantity);
  }

  public static <K, V> MapData<K, V> map(Iterable<K> genK, Generator<V> genV) {
    return new MapData<K, V>(genK, genV);
  }

  public static <K, V> MapData<K, V> map(Iterable<K> genK, V value) {
    return new MapData<K, V>(genK, value);
  }
}
