package jsoncompare;

import java.util.Random;

/**
 * @author yanshilong5@jd.com
 * @date 2020/8/18 20:23
 * @since JDK 1.8
 * desc：
 */
public class test1 {


    public static void main(String[] args) {
        String b=String.valueOf(1);
        String c=b;
        int a = 123456789;


        long start = System.currentTimeMillis();
        for (int i=0; i<1000000; i++){
            String m = a+"";
//            Integer.toString(a);
        }
        char[] buf = new char[2];
        buf[0]='1';
        buf[1]='2';

        long end = System.currentTimeMillis();

        System.out.println("a+“” 执行时间：" + (end - start)+" 毫秒");

//
    }
}
