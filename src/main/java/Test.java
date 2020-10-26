import java.math.BigDecimal;
import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {

        StackTraceElement[] stacks=Thread.currentThread().getStackTrace();
        System.out.println("1"+stacks[0]);
        System.out.println("2"+stacks[1]);
//        System.out.println(stacks[2]);
        StackTraceElement e=stacks[1];
        System.out.println(e.getClassName());
        System.out.println(e.getMethodName());
        String ss="2222222222222";
        BigInteger v=new BigInteger(ss);
        BigInteger s=new BigInteger("2");
        System.out.println(v);
        String aa="";
        System.out.println(Long.MAX_VALUE);

    }
}
