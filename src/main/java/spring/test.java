package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppConfig;
import spring.services.ServicesA;

/**
 * @author yanshilong5@jd.com
 * @date 2021/8/7 20:56
 * @since JDK 1.8
 * desc：
 */
public class test {
    public static void main(String[] args) {
        //初始化spring bean容器
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);

        applicationContext.getBean(ServicesA.class).say();


    }
}
