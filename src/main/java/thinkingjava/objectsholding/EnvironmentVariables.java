package thinkingjava.objectsholding;

import java.util.Map;

/**
 * 显示所有的操作系统环境变量
 *
 * @author 李重辰
 * @date 2018/11/21 12:23
 */
public class EnvironmentVariables {
  public static void main(String[] args) {
    for (Map.Entry entry : System.getenv().entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
