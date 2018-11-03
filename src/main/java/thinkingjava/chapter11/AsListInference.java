package thinkingjava.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 李重辰
 * @date 2018/11/2 21:44
 */
public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snowList = Arrays.asList(new Crusty(), new Slush(), new Powder());
        List<Snow> snowList1 = Arrays.asList(new Light(), new Heavy());

        ///使用Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，
        // 它的add/remove/clear方法会抛出UnsupportedOperationException异常。
        // 说明：asList的返回对象是一个Arrays内部类，并没有实现集合的修改方法。
        // Arrays.asList体现的市适配器模式，只是转换接口，后台的数据仍是数组。
         //String[] str = new String[]{"you", "wu"};
         //List list = Arrays.asList(str);
         //str[0] = "gujin";    //那么list.get(0)也会随之修改
        Collections.addAll(snowList,new Light(), new Heavy());
        snowList.add(new Light());
        List<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3, new Light(), new Heavy());

        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
    }
}

class Snow{}

/**
 * 粉末
 */
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}

/**
 * 硬壳的
 */
class Crusty extends Snow{}

/**
 * 烂泥
 */
class Slush extends Snow{}