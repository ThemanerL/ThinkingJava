package cleancode.chapter14.marshalerimpl;

import cleancode.chapter14.ArgsException;
import cleancode.chapter14.ArgumentMarshaler;
import cleancode.chapter14.ErrorCode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author 李重辰
 * @date 2020/12/25 14:20
 */
public class IntegerArgumentMarshaler implements ArgumentMarshaler {
  private int intValue = 0;

  @Override
  public void set(Iterator<String> currentArgument) throws ArgsException {
    String parameter = null;
    try {
      parameter = currentArgument.next();
      intValue = Integer.parseInt(parameter);
    } catch (NoSuchElementException e) {
      throw new ArgsException(ErrorCode.MISSING_INTEGER);
    } catch (NumberFormatException e) {
      throw new ArgsException(ErrorCode.INVALID_INTEGER, parameter);
    }
  }

  public static int getValue(ArgumentMarshaler am) {
    if (am instanceof IntegerArgumentMarshaler) {
      return ((IntegerArgumentMarshaler) am).intValue;
    } else {
      return 0;
    }
  }
}
