package jedis;

import lombok.NonNull;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author 李重辰
 * @date 2019/7/6 0:05
 */
public class ConnectRedis {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.56.128", 6379);
        new ConnectRedis().baseCommend(jedis);
    }


    /**
     * 基本命令联系与熟悉
     */
    private void baseCommend(@NonNull Jedis jedis) {
        Set<String> keys = jedis.keys("*");
        keys.forEach(System.out::println);
        jedis.set("k1", "v1");
        jedis.set("k2", "v2");
        System.out.println(jedis.exists("k2"));
        System.out.println(jedis.ttl("k1"));
        System.out.println(jedis.get("k4"));
        jedis.mset("m1", "n1", "m2", "", "m3", "n3");
        System.out.println("------------list------------");
        List<String> list = jedis.lrange("mylsit", 0, -1);
        list.forEach(System.out::println);
        System.out.println(jedis.lindex("mylsit", 0));
        System.out.println("-------Hash---------");
        HashMap<String, String> hashMap = new HashMap<>(16);
        hashMap.put("A", "a");
        hashMap.put("B", "2");
        hashMap.put("Name", "joey");
        hashMap.put("Address", "固戍二路");
        jedis.hset("hash1", hashMap);
        jedis.hmget("hash1", "A", "B", "Name").forEach(System.out::println);
    }
}
