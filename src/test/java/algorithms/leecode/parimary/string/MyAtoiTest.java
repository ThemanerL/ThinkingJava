package algorithms.leecode.parimary.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 李重辰
 * @date 2019/9/4 10:14
 */
public class MyAtoiTest {

  private MyAtoi myAtoi;

  @Before
  public void before() {
    myAtoi = new MyAtoi();
  }

  @Test
  public void testOne() {
    String case1 = "4193 with words";
    Assert.assertEquals(4193, myAtoi.solutionTwo(case1));
  }

  @Test
  public void testTwo() {
    String case2 = "3.141578";
    Assert.assertEquals(3, myAtoi.solutionTwo(case2));
  }

  @Test
  public void testThree() {
    String case3 = "-91283472332";
    Assert.assertEquals(-2147483648, myAtoi.solutionTwo(case3));
  }

  @Test
  public void testFour() {
    String case4 = "   -42";
    Assert.assertEquals(-42, myAtoi.solutionTwo(case4));
  }

  @Test
  public void testFive() {
    String case5 = "+";
    Assert.assertEquals(0, myAtoi.solutionTwo(case5));
  }

  @Test
  public void testSix() {
    String case6 = "+1";
    Assert.assertEquals(1, myAtoi.solutionTwo(case6));
  }

  @Test
  public void testSeven() {
    String case7 = "-9";
    Assert.assertEquals(-9, myAtoi.solutionTwo(case7));
  }

  @Test
  public void testEight() {
    String case8 = "";
    Assert.assertEquals(0, myAtoi.solutionTwo(case8));
  }

  @Test
  public void testNine() {
    String case9 = "-5-";
    Assert.assertEquals(-5, myAtoi.solutionTwo(case9));
  }

  @Test
  public void testTen() {
    String case10 = "   +0 123";
    Assert.assertEquals(0, myAtoi.solutionTwo(case10));
  }

  @Test
  public void testEleven() {
    String case11 = " ";
    Assert.assertEquals(0, myAtoi.solutionTwo(case11));
  }

  @Test
  public void testSolutionTwo() {
//    String case1 = "  1";
//    Assert.assertEquals(1, myAtoi.solutionTwo(case1));

    String case2 = "   +42";
    Assert.assertEquals(42, myAtoi.solutionTwo(case2));
  }
}