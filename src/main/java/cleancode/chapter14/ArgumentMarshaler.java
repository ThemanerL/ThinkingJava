package cleancode.chapter14;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author 李重辰
 * @date 2020/12/25 9:52
 */
public interface ArgumentMarshaler {
  void set(Iterator<String> currentArgument) throws ArgsException;
}
