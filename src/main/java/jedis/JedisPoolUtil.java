package jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPool;

/**
 * @author 李重辰
 * @date 2019/7/9 23:11
 */
class JedisPoolUtil {

    private static volatile JedisPool JEDISPOOL = null;

    private JedisPoolUtil() {
    }

    static JedisPool getJedisPoolInstance() {
        if (null == JEDISPOOL) {
            synchronized (JedisPoolUtil.class) {
                if (null == JEDISPOOL) {
                    GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
                    poolConfig.setMaxTotal(8);
                    poolConfig.setMinIdle(0);
                    JEDISPOOL = new JedisPool(poolConfig, "192.168.56.128", 6379);
                }
            }
        }

        return JEDISPOOL;
    }

}
