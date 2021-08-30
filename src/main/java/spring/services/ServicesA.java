package spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yanshilong5@jd.com
 * @date 2021/8/7 20:58
 * @since JDK 1.8
 * desc：
 */
@Component
public class ServicesA {

    @Autowired
    ServicesB servicesB;

    public ServicesA(){
        System.out.println("ServiceA加载");
    }

    public void  say(){
        System.out.println(servicesB.hashCode());
    }
}
