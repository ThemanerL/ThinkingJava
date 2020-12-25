package cleancode.chapter14.marshalerimpl;

import cleancode.chapter14.ArgsException;
import cleancode.chapter14.ArgumentMarshaler;
import cleancode.chapter14.ErrorCode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author 李重辰
 * @date 2020/12/25 14:24
 */
public class DoubleArgumentMarshaler implements ArgumentMarshaler {
  private double doubleValue = 0;

  @Override
  public void set(Iterator<String> currentArgument) throws ArgsException {
    String parameter = null;
    try {
      parameter = currentArgument.next();
      doubleValue = Double.parseDouble(parameter);
    } catch (NoSuchElementException e) {
      throw new ArgsException(ErrorCode.MISSING_DOUBLE);
    } catch (NumberFormatException e) {
      throw new ArgsException(ErrorCode.INVALID_DOUBLE, parameter);
    }
  }

  public static double getValue(ArgumentMarshaler am) {
    if (am instanceof DoubleArgumentMarshaler) {
      return ((DoubleArgumentMarshaler) am).doubleValue;
    } else {
      return 0;
    }
  }

}
