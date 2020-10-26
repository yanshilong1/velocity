package mapdb;

import mapdb.Impl.mapDbServiceImpl;

/**
 * @author yanshilong5@jd.com
 * @date 2020/10/26 20:48
 * @since JDK 1.8
 * desc：
 */
public class Test {
    public static void main(String[] args) {
        mapDbService service=new mapDbServiceImpl();
//        service.setValue("test","test");

        System.out.println(service.getValue("test"));
    }
}
