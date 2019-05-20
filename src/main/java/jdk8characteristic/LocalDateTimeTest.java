package jdk8characteristic;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * 1. Local LocalTime LocalDateTime
 * 这些类不管做什么样的改变都产生新的实例
 *
 * @author 李重辰
 * @date 2019/5/19 15:20
 */
public class LocalDateTimeTest {

  @Test
  public void test1() {
    LocalDateTime time = LocalDateTime.now();
    System.out.println(time);

    LocalDateTime time1 = LocalDateTime.of(2019, 5, 27, 14, 42, 12);
    System.out.println(time1);
  }

  /**
   * 2. Instant 时间戳(以Unix元年 1970-01-01 00:00:00到某个时间的毫秒值)
   */
  @Test
  public void test2() {
    // 默认获取的是UTC时区，格林威治
    Instant instant = Instant.now();
    System.out.println(instant);
    OffsetDateTime time = instant.atOffset(ZoneOffset.ofHours(8));
    System.out.println(time);
    System.out.println("毫秒时间: " + time.toInstant().toEpochMilli());
  }

  /**
   * 3. Duration:计算两个"时间"之间的间隔
   * Period:计算两个"日期"之间的间隔
   */
  @Test
  public void test3() {
    Instant instant = Instant.now();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Instant instant1 = Instant.now();
    Duration duration = Duration.between(instant, instant1);
    System.out.println(duration.toMillis());

    LocalDate localDateTime1 = LocalDate.now();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    LocalDate localDateTime2 = LocalDate.now().plusDays(3);
    System.out.println(Period.between(localDateTime1, localDateTime2).getDays());
  }

  @Test
  public void test4() {
    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyy-MM-hh hh:mm:ss");
    LocalDateTime localDateTime = LocalDateTime.now();
    String s = formatter.format(localDateTime);
    String s2 = formatter2.format(localDateTime);
    System.out.println(s);
    System.out.println(s2);
  }
}
