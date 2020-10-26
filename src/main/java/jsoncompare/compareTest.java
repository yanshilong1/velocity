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
//        Stu stu1 = new Stu("张四", 12, 22L);
//        Stu stu2 = new Stu("张三", 12, 22L);
//        Map resMap = JsonUtil.doCompare(JSON.toJSONString(stu1), JSON.toJSONString(stu2));
//        resMap.forEach((k, v) -> {
//            System.out.println(k);
//            System.out.println(v);
//        });
////        System.out.println("res="+resMap.);
//
//
//        int i = 10;
//        String str="10";
//        str=Integer.toString(i);
//        str=String.valueOf(str);
//        str=i+"";
        int a = 123456789;
        Object b=new Object();

        int s=1+a;


        long start = System.currentTimeMillis();
        for (int i=0; i<1000000; i++){
            String m = a+"";
        }
        long end = System.currentTimeMillis();
        System.out.println("a+“” 执行时间：" + (end - start)+" 毫秒");

         start = System.currentTimeMillis();
        for (int i=0; i<1000000; i++){
            String n = String.valueOf(b);
        }
        end = System.currentTimeMillis();

        System.out.println("String.valueOf(a) 执行时间：" +(end-start)+" 毫秒");





        start = System.currentTimeMillis();
        for (int i=0; i<10000000; i++){
            String n = Integer.toString(a);

        }
        end = System.currentTimeMillis();
        System.out.println("Integer.toString(a) 执行时间：" +(end-start)+" 毫秒");



    }






}
