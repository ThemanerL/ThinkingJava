package jdk8characteristic.exception;

/**
 * @author 李重辰
 * @date 2020/6/11 15:18
 */
public class EntityNullException extends Exception {
  private static final long serialVersionUID = 2320541678257312822L;

  public EntityNullException(String msg) {
    super(msg);
  }
}
