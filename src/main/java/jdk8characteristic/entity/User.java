package jdk8characteristic.entity;

import lombok.Data;

import java.util.Optional;

/**
 * @author 李重辰
 * @date 2020/6/11 9:21
 */
@Data
public class User {
  private String name;
  private int age;
  private int sex;
  private Address address;
  private String country;

  public Optional<Address> getOptionalAddress() {
    return Optional.ofNullable(address);
  }

  public static UserBuild build() {
    return new UserBuild();
  }

  public static class UserBuild {
    private final User user;

    public UserBuild() {
      this.user = new User();
    }

    public UserBuild setAge(int age) {
      user.age = age;
      return this;
    }

    public UserBuild setName(String name) {
      user.name = name;
      return this;
    }

    public UserBuild setSex(int sex) {
      user.sex = sex;
      return this;
    }

    public UserBuild setAddress(Address address) {
      user.address = address;
      return this;
    }

    public User getUser() {
      return user;
    }

  }
}
