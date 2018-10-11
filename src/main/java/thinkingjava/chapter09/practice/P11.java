package thinkingjava.chapter09.practice;

import thinkingjava.chapter09.filters.Filter;

import java.util.Arrays;

/**
 * @author 李重辰
 * @date 2018/10/11 16:43
 */
public class P11 extends Filter {
    /**
     * 将每一对字符进行互换
     * @param s 传入一个字符串
     * @return 返回结果
     */
    private String reverseString (String s){
        char[] a = s.toCharArray();
        for(int i = 0; i < a.length-1; i=i+2){
            char temp = a[i];
            a[i] = a[i+1];
            a[i+1] = temp;
        }
        return new String(a);
    }

    public static void main(String[] args) {
        P11 p = new P11();
        System.out.println(p.reverseString("My name is Joey"));
    }
}
