package thinkingjava.chapter11.practice;

/**
 * @author 李重辰
 * @date 2018/11/5 20:17
 */
public class P4 {
}

class Generate{
    private String originChar = "My name is Li The Man er!";
    private char[] chars = originChar.toCharArray();
    String  next (){
        StringBuilder  stringBuilder = new StringBuilder ();
        for(int i = 0; i < chars.length; i++){
            if(i <= chars.length-1){
                stringBuilder.append(chars[i]);
                stringBuilder.append(chars[i+1]);
            }
        }
        return new String(stringBuilder);
    }

}
