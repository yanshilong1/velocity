public class Test {
    public static void main(String[] args) {

        StackTraceElement[] stacks=Thread.currentThread().getStackTrace();
        System.out.println("1"+stacks[0]);
        System.out.println("2"+stacks[1]);
//        System.out.println(stacks[2]);
        StackTraceElement e=stacks[1];
        System.out.println(e.getClassName());
        System.out.println(e.getMethodName());


    }
}
