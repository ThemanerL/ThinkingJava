package thinkingjava.generics;

interface Payable {

}

/**
 * 当Payable设定了泛型参数，即Payable<T>时，Hourly将不能编译
 * 因为擦除会将Payable<Employee>和Payable<Hourly>简化为相同的类Payable，这样意味着重复两次实现相同的接口。
 *
 * @author 李重辰
 * @date 2020/1/7 19:43
 */
public class MultipleInterfaceVariants {
}

class Employee implements Payable {
}

class Hourly extends Employee implements Payable {
}
