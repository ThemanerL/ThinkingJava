package thinkingjava.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author 李重辰
 * @date 2018/11/29 18:14
 */
public class LoggingException2 {
  private static Logger logger = Logger.getLogger("LoggingException2");

  public static void logException(Exception e) {
    StringWriter writer = new StringWriter();
    e.printStackTrace(new PrintWriter(writer));
    logger.severe(writer.toString());
  }

  public static void main(String[] args) {
    try {
      throw new NullPointerException();
    } catch (NullPointerException e) {
      logException(e);
    }
  }
}
