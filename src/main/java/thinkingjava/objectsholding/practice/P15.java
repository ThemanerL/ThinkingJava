package thinkingjava.objectsholding.practice;

import thinkingjava.objectsholding.Stack;

/**
 * @author 李重辰
 * @date 2018/11/13 10:05
 */
public class P15 {
  public static void main(String[] args) {
    String target = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
    Stack<Character> characterStack = new Stack<>();
    char[] chars = target.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      switch (chars[i]) {
        case '+':
          characterStack.push(chars[i + 1]);
          break;
        case '-':
          System.out.print(characterStack.pop());
          break;
        default:
          break;
      }
    }
  }
}
