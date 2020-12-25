package cleancode.chapter14.marshalerimpl;

import cleancode.chapter14.ArgsException;
import cleancode.chapter14.ArgumentMarshaler;

import java.util.Iterator;

/**
 * @author 李重辰
 * @date 2020/12/25 14:24
 */
public class StringArrayArgumentMarshaler implements ArgumentMarshaler {
  @Override
  public void set(Iterator<String> currentArgument) throws ArgsException {

  }

  public static String[] getValue(ArgumentMarshaler argumentMarshaler) {
    return new String[0];
  }

}
