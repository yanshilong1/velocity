package guava;

import com.google.common.cache.Cache;
import entity.Stu;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanshilong5@jd.com
 * @date 2020/7/27 20:19
 * @since JDK 1.8
 * desc：测试类
 */
public class test {
    public static void main(String[] args) throws InterruptedException {

        Cache cache1 = guavaCache.createCache(10).getCache();
        cache1.put("1", "2");
        System.out.println(cache1.getIfPresent("1"));
        Thread.sleep(2000);
        System.out.println(cache1.getIfPresent("1"));

        Cache cache2 = guavaCache.createCache(10).getCache();
        System.out.println(cache1 == cache2);
        Stu s = new Stu();
        long aa = s.getLongval();
        System.out.println("val=" + s.getLongval());
//        s.setLongval(null);
        System.out.println("aaaa" + aa);
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Instant.now().getEpochSecond();//10);
        }
        long e1 = System.currentTimeMillis();
        long s2 = System.currentTimeMillis();
        for (int t = 0; t < 1000000; t++) {
            long date = new Date().getTime()/1000L;

        }
        long e2 = System.currentTimeMillis();
        System.out.println("java8耗时" + (e1 - s1));
        System.out.println("new Date耗时" + (e2 - s2));
//        System.out.println(Instant.now().getNano());//10);
//        System.out.println(new Date().getTime());//10);
//        System.out.println(Instant.ofEpochMilli(0));
//    }

        System.out.println(new Date().getTime()/1000L);
        System.out.println(Instant.now().getEpochSecond());

        LocalDateTime newData=LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = newData.atZone(zone).toInstant();
        long times=instant.getEpochSecond();

        System.out.println("毫秒级时间戳："+new Date().getTime());

        System.out.println("秒级别时间戳："+getSecondTimeTampLong());


        Map map=System.getenv();
        map.forEach((k,v)->{
//            System.out.println("key:"+k);
//            System.out.println("value:"+v);
//            System.out.println("~~~~~~~~~~~~");
        });

        System.out.println(System.getenv("NUMBER_OF_PROCESSORS"));
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public static long getSecondTimeTampLong(){
        return  getSecondTimestampByDateTime(getNow());
    }

    static LocalDateTime getNow(){
        return LocalDateTime.now();
    }
    public static long getSecondTimestampByDateTime(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.getEpochSecond();
    }
}
