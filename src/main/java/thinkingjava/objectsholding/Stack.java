package thinkingjava.objectsholding;

import java.util.LinkedList;

/**
 * 类名之后的<T>告诉编译器这是一个参数化类型，而其中的类型参数，在类被使用的时候会被实际类型替换
 * @author 李重辰
 * @date 2018/11/12 20:43
 */
public class Stack<T> {
  private LinkedList<T> storage = new LinkedList<>();

  public void push(T v) {
    storage.addFirst(v);
  }

  public T peek() {
    return storage.getFirst();
  }

  public T pop() {
    return storage.removeFirst();
  }

  public boolean empty(){
    return storage.isEmpty();
  }

  @Override
  public String toString() {
    return "Stack{" +
        "storage=" + storage.toString() +
        '}';
  }
}

class StackTest{
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
  }
}
