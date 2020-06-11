package jdk8characteristic.entity;

import lombok.Data;

import java.util.Optional;

/**
 * @author 李重辰
 * @date 2020/6/11 11:35
 */
@Data(staticConstructor = "of")
public class Address {

  private String country;
  private String isoCode;

  public Optional<String> getOptionalIsoCode() {
    return Optional.ofNullable(isoCode);
  }

  public Optional<Address> getOptionalAddress() {
    return Optional.of(this);
  }
}
