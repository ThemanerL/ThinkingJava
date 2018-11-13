package thinkingjava.chapter11;

import thinkingjava.net.mindview.util.TextFile;

import java.util.Set;
import java.util.TreeSet;

/**
 * 只有把.java文件放在特定目录才行，有点问题。重点不是这个，忽略
 * @author 李重辰
 * @date 2018/11/13 20:41
 */
public class UniqueWords {
  public static void main(String[] args) {
    Set<String> words = new TreeSet<>(
        new TextFile("SetOperations.java", "\\w+")
    );
    System.out.println(words);
  }
}
