package algorithms.leecode.primary.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 李重辰
 * @date 2019/9/6 11:30
 */
public class StrStrTest {

  private StrStr strStr;

  @Before
  public void setUp() throws Exception {
    strStr = new StrStr();
  }

  @Test
  public void solutionTest() {
//    Assert.assertEquals(3, strStr.solution("hlello", "ll"));
//    Assert.assertEquals(1, strStr.solution("hlello", "l"));
//    Assert.assertEquals(-1, strStr.solution("aaa", "aaaa"));
//    Assert.assertEquals(0, strStr.solution("aaa", "a"));
    assertEquals(-1, strStr.solution("mississippi", "issipi"));
  }
}
