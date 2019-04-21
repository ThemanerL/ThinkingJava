package thinkingjava.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author 李重辰
 * @date 2018/11/29 17:53
 */
public class LoggingExceptions {
  public static void main(String[] args) {
    try {
      throw new LoggingException();
    } catch (LoggingException e) {
      System.err.println("Caught " + e);
    }
    try {
      throw new LoggingException();
    } catch (LoggingException e) {
      System.err.println("Caught " + e);
    }
  }
}

class LoggingException extends Exception {
  /**
   * 创建了一个String参数关联的Logger对象（通常和错误相关的包名和类名）
   */
  private static Logger logger = Logger.getLogger("LoggerExceptions");

  public LoggingException() {
    StringWriter writer = new StringWriter();
    // 获取异常抛出处的栈轨迹，由于printStackTrace方法不会默认的产生字符串，所以使用重载的
    // public void printStackTrace(PrintWriter s) 方法
    printStackTrace(new PrintWriter(writer));
    logger.severe(writer.toString());
  }
}