package cleancode.chapter14.marshalerimpl;

import cleancode.chapter14.ArgsException;
import cleancode.chapter14.ArgumentMarshaler;

import java.util.Iterator;

/**
 * @author 李重辰
 * @date 2020/12/25 14:12
 */
public class BooleanArgumentMarshaler implements ArgumentMarshaler {
  private boolean booleanValue = false;

  @Override
  public void set(Iterator<String> currentArgument) throws ArgsException {
    booleanValue = true;
  }

  public static boolean getValue(ArgumentMarshaler am) {
    if (am instanceof BooleanArgumentMarshaler) {
      return ((BooleanArgumentMarshaler) am).booleanValue;
    } else {
      return false;
    }
  }
}
