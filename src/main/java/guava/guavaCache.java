package guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author yanshilong5@jd.com
 * @date 2020/7/27 19:43
 * @since JDK 1.8
 * desc：本地缓存工具类基于guava
 */
@Data
@Getter
@Slf4j
public class guavaCache<K, V> {



    public void setCache(Cache<K, V> cache) {
        this.cache = cache;
    }

    /**
     * 默认的本地缓存最大数据长度,容量超过此数量之后会进行key淘汰
     */
    private static final long Default_Maximum_Size = 5000;
    /**
     * 本地缓存数据长度为1
     */
    private static final long Single_Size = 1;

    /**
     * 写入本地缓存后的失效时间秒数
     */
    private static final long Max_Expire_After_Write = 1 * 60;

    //guava缓存类
    private  Cache<K, V> cache;

    //单例实体类
    private static  guavaCache instance;

    //默认构造函数
    guavaCache(){}

    public static<K,V> guavaCache<K,V> createCache(long expireTime){
        if(Objects.isNull(instance)){
            synchronized (guavaCache.class){
                if(Objects.isNull(instance)){
                    instance=new guavaCache();
                    log.info("初始化缓存对象-----");
                    //初始化instance
                    instance.cache=CacheBuilder.newBuilder().maximumSize(Default_Maximum_Size).expireAfterWrite(expireTime <=0 ? Max_Expire_After_Write:expireTime, TimeUnit.MINUTES).
                            build();
                }
            }
        }
        return instance;
    }

    static<K,V> Cache<K,V>  getCache(){
        return instance.cache;
    }

}
