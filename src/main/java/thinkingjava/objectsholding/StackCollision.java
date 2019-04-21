package thinkingjava.objectsholding;

/**
 * @author 李重辰
 * @date 2018/11/12 21:44
 */
public class StackCollision {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    String str = "My name is li zhong chen";
    String interval = " ";
    for (String s : str.split(interval)){
      stack.push(s);
    }
    while(!stack.empty()){
      System.out.println(stack.pop() + " ");
    }
    System.out.println("---------------------");
    java.util.Stack<String> stack1 = new java.util.Stack<>();
    for (String s : str.split(interval)){
      stack1.push(s);
    }
    while(!stack1.empty()){
      System.out.println(stack1.pop() + " ");
    }
  }
}
