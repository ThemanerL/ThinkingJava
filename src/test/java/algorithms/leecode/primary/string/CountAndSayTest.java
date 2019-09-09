package algorithms.leecode.primary.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 李重辰
 * @date 2019/9/6 20:24
 */
public class CountAndSayTest {

  private CountAndSay countAndSay;

  @Before
  public void setUp() throws Exception {
    countAndSay = new CountAndSay();
  }

  @Test
  public void solution() {
    Assert.assertEquals("111221", countAndSay.solution("1211"));
  }
}