package cleancode.chapter14.marshalerimpl;

import cleancode.chapter14.ArgsException;
import cleancode.chapter14.ArgumentMarshaler;
import cleancode.chapter14.ErrorCode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author 李重辰
 * @date 2020/12/25 14:16
 */
public class StringArgumentMarshaler implements ArgumentMarshaler {
  private String stringValue = "";

  @Override
  public void set(Iterator<String> currentArgument) throws ArgsException {
    try {
      stringValue = currentArgument.next();
    } catch (NoSuchElementException e) {
      throw new ArgsException(ErrorCode.MISSING_STRING);
    }
  }

  public static String getValue(ArgumentMarshaler am) {
    if (am instanceof StringArgumentMarshaler) {
      return ((StringArgumentMarshaler) am).stringValue;
    } else {
      return "";
    }
  }
}