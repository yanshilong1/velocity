package guava;

import com.google.common.cache.Cache;

/**
 * @author yanshilong5@jd.com
 * @date 2020/7/27 20:19
 * @since JDK 1.8
 * desc：
 */
public class test {
    public static void main(String[] args) throws InterruptedException {
        guavaCache cache=guavaCache.createCache(1);
         Cache cache1=cache.getCache();
         cache1.put("1","2");
        System.out.println(cache1.getIfPresent("1"));
        Thread.sleep(2000);
        System.out.println(cache1.getIfPresent("1"));
    }
}
