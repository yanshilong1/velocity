package asyn;

import com.google.common.util.concurrent.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yanshilong5@jd.com
 * @date 2021/8/7 13:43
 * @since JDK 1.8
 * desc：异步编程：a b 完成时执行c，c需要用到a和b的返回结果，c里需要有RPC调用，c完成后执行d，d的执行需要用c的输出
 */
public class FutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        /**
         * 方式1  用ComplateFuture实现8
         * */
        //任务a
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            return func("任务a");
        });

        //任务b
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {

            return func("任务b");
        });

        //任务c,等待a、b执行完成并使用a、d的结果
        CompletableFuture<String> futureC = futureA.thenCombine(futureB, (a, b) -> {
            //a 是任务a 的返回值    b是任务b的返回值
            rpcFunc();
            return func(a + b);

        });

        //任务d,等待任务c完成，需要使用c返回值,但是任务d本身无返回值,使用thenAccept
        CompletableFuture<Void> futureD = futureC.thenAccept((c) -> {
            func("c");
        });
        //超时时间
        futureD.get(15, TimeUnit.SECONDS);
        System.out.println("方式1 执行完成-----------------------------------------------");
        System.out.println();


        /**
         * 方式2 用ListenableFuture实现
         * */

        System.out.println("方式2 执行开始-----------------------------------------------");
        Thread.sleep(5);

        //创建一个异步执行service
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));

        //异步监听方法列表
        List<ListenableFuture<Integer>> listenableFuturesList = new ArrayList<>(1);


        //任务a
        listenableFuturesList.add(service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                func("任务1");
                return 1;
            }
        }));
        //任务b
        listenableFuturesList.add(service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                func("任务2");
                return 2;
            }
        }));


        //处理任务a 和任务b 的执行结果
        ListenableFuture<Integer> futureResult = Futures.transformAsync(Futures.allAsList(listenableFuturesList), new AsyncFunction<List<Integer>, Integer>() {
            @Override
            public ListenableFuture<Integer> apply(List<Integer> integers) throws Exception {
                AtomicReference<Integer> a = new AtomicReference<>(0);
                integers.forEach(integer -> {
                    a.set(a.get() + integer);
                });
                return Futures.immediateFuture(a.get());
            }
        });


        // 任务c  异步执行函数  integer为入参，Boolean作为出参
        AsyncFunction<Integer, Boolean> asyncFunction = new AsyncFunction<Integer, Boolean>() {
            public ListenableFuture<Boolean> apply(Integer rowKey) {
                System.out.println("任务1、2执行成功，计算结果" + rowKey);

                ListenableFuture<Boolean> hot = service.submit(new Callable<Boolean>() {

                    @Override
                    public Boolean call() throws Exception {
                        rpcFunc();
                        return true;
                    }
                });
                return hot;
            }
        };

        //任务执行c的等待任务a、b
        ListenableFuture execFuture = Futures.transformAsync(futureResult, asyncFunction, service);
        Futures.addCallback(execFuture, new FutureCallback<Boolean>() {
            //任务4是任务3的回调
            @Override
            public void onSuccess(Boolean aBoolean) {
                func("任务4");
                System.out.println("方式2 执行结束-----------------------------------------------");
                service.shutdown();
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("");
            }

        }, service);
    }


    /**
     * Description: 模拟方法
     *
     * @param
     * @author: yanshilong5@jd.com
     * @creation: 2021/8/7 14:03
     * @return:
     */

    public static String func(String name) {
        try {
            Thread.sleep(new Random().nextInt(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "->执行完成");
        return name;
    }


    /**
     * Description: 模拟rpc方法
     *
     * @param
     * @author: yanshilong5@jd.com
     * @creation: 2021/8/7 14:04
     * @return:
     */
    public static String rpcFunc() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "rpc finish";
    }

}
