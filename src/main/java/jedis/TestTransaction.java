package jedis;

import lombok.NonNull;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author 李重辰
 * @date 2019/7/9 22:10
 */
public class TestTransaction {

  public static void main(String[] args) {
    try (Jedis jedis1 = JedisPoolUtil.getJedisPoolInstance().getResource()) {
      TestTransaction transaction = new TestTransaction();
      System.out.println(transaction.trans(jedis1));
    }
  }

  /**
   * redis事务
   */
  private void transaction(@NonNull Jedis jedis) {
    Transaction transaction = jedis.multi();
    transaction.set("k7", "k7");
    transaction.set("k9", "k9");
    transaction.discard();
//        transaction.exec();
  }

  private boolean trans(@NonNull Jedis jedis) {
    // 可透支额度
    int balance;

    // 已欠金额
    int debt;

    // 实际消费金额
    int actualMount = 10;

    jedis.watch("balance");
    System.out.println("消费前负债" + jedis.get("debt"));
    balance = Integer.parseInt(jedis.get("balance"));
    System.out.println("消费前额度" + balance);
    if (balance < actualMount) {
      jedis.unwatch();
      System.out.println("支付失败");
      return false;
    }
    try {
      System.out.println("_________");
      System.out.println("watch中的额度" + balance);
      Thread.sleep(10000);
      System.out.println("watch后的额度" + jedis.get("balance"));
      System.out.println("_________");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("----事务开始了----");
    Transaction multi = jedis.multi();
    multi.incrBy("debt", actualMount);
    multi.decrBy("balance", actualMount);
    multi.exec();
    System.out.println("消费后负债" + jedis.get("debt"));
    System.out.println("消费后额度" + jedis.get("balance"));
    return true;
  }


}
