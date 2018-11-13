package thinkingjava.net.mindview.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author 李重辰
 * @date 2018/11/13 20:31
 */
public class TextFile extends ArrayList<String> {
  /**
   * Read a file as a single string:
   * @param fileName 文件名
   * @return /
   */
  public static String read(String fileName) {
    StringBuilder sb = new StringBuilder();
    try {
      BufferedReader in = new BufferedReader(new FileReader(
          new File(fileName).getAbsoluteFile()));
      String s;
      while ((s = in.readLine()) != null) {
        sb.append(s);
        sb.append("\n");
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return sb.toString();
  }

  /**
   * Write a single file in one method call:
   * @param fileName 文件名
   * @param text     /
   */
  public static void write(String fileName, String text) {
    try {
      PrintWriter out = new PrintWriter(
          new File(fileName).getAbsoluteFile());
      try {
        out.print(text);
      } finally {
        out.close();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Read a file, split by any regular expression:
   * @param fileName /
   * @param splitter /
   */
  public TextFile(String fileName, String splitter) {
    super(Arrays.asList(read(fileName).split(splitter)));
    // Regular expression split() often leaves an empty
    // String at the first position:
    if ("".equals(get(0))) {
      remove(0);
    }
  }

  /**
   * Normally read by lines:
   * @param fileName /
   */
  public TextFile(String fileName) {
    this(fileName, "\n");
  }

  public void write(String fileName) {
    PrintWriter out = null;
    try {
      out = new PrintWriter(
          new File(fileName).getAbsoluteFile());
      for (String item : this) {
        out.println(item);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      try{
        if (out != null){
          out.close();
        }
      }catch (Exception e){
        e.printStackTrace();
      }
    }
  }

  /**
   * 测试类
   * @param args /
   */
  public static void main(String[] args) {
    String file = read("TextFile.java");
    write("test.txt", file);
    TextFile text = new TextFile("test.txt");
    text.write("test2.txt");
    // Break into unique sorted list of words:
    TreeSet<String> words = new TreeSet<>(
        new TextFile("TextFile.java", "\\W+"));
    // Display the capitalized words:
    System.out.println(words.headSet("a"));
  }
} /* Output:
[0, ArrayList, Arrays, Break, BufferedReader, BufferedWriter, Clean, Display, File, FileReader, FileWriter, IOException, Normally, Output, PrintWriter, Read, Regular, RuntimeException, Simple, Static, String, StringBuilder, System, TextFile, Tools, TreeSet, W, Write]
*///:~
