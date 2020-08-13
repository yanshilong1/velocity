import entity.Stu;

import java.util.logging.Logger;

/**
 * @author yanshilong5@jd.com
 * @date 2020/7/24 21:53
 * @since JDK 1.8
 * desc：通过newInstance的方式创建新类
 */
public class Tes {
    private static Logger logger=Logger.getLogger(String.valueOf(Tes.class));
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.info("你好");

        Stu stu=new Stu();
        String s=stu.getClass().getName();
        Object stuObject=Class.forName(s).newInstance();
        Stu stu1=(Stu)stuObject;
        stu1.setAge(11);
        System.out.println(stu1);
    }
}

