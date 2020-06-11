package jdk8characteristic;

import jdk8characteristic.entity.Address;
import jdk8characteristic.entity.User;
import jdk8characteristic.exception.EntityNullException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * 复习Optional的使用
 *
 * @author 李重辰
 * @date 2020/6/8 20:29
 */
public class OptionalTest {
  public static void main(String[] args) throws EntityNullException {
    String name = "John";
    Optional<String> opt = Optional.of(name);
    assertEquals("John", opt.get());

    Address address = Address.of();
    address.setCountry("中国");
    User user = User.build().setAddress(address).setAge(18).getUser();
    System.out.println(user);
    Optional.ofNullable(user).ifPresent(user1 -> System.out.println(user1.getAge()));
    Optional.ofNullable(user).orElseThrow(() -> new EntityNullException("USER IS NULL"));
    String isoCode = Optional.ofNullable(user).map(user1 -> user1.getAddress().getIsoCode()).orElse("122");
    System.out.println(isoCode);
    user.getAddress().setIsoCode("ABCD");
    String s = Optional.ofNullable(user).flatMap(user1 -> user1.getAddress().getOptionalIsoCode()).orElse("1254");
    String isoCode2 = Optional.ofNullable(user).flatMap(User::getOptionalAddress).flatMap(Address::getOptionalAddress).map(Address::getIsoCode).get();
    System.out.println(isoCode2);
    // jdk9+
    List<Address> collect = Optional.ofNullable(user).stream().filter(u -> u.getAddress() != null).map(User::getAddress).collect(Collectors.toList());
    collect.forEach(System.out::println);
  }

}
