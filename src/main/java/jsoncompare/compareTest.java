package jsoncompare;

import com.alibaba.fastjson.JSON;
import entity.Stu;

import java.util.Map;

/**
 * @author yanshilong5@jd.com
 * @date 2020/8/10 18:28
 * @since JDK 1.8
 * desc字符串对比工具
 */
public class compareTest {
    public static void main(String[] args) {
        Stu stu1=new Stu("张四",12,22L);
        Stu stu2=new Stu("张三",12,22L);
        Map resMap=JsonUtil.doCompare(JSON.toJSONString(stu1),JSON.toJSONString(stu2));
        resMap.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });
//        System.out.println("res="+resMap.);
    }
}
