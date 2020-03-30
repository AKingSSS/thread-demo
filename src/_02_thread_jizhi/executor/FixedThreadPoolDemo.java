package _02_thread_jizhi.executor;

import java.util.concurrent.*;

import static java.util.concurrent.Executors.*;
import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @ClassName FixedThreadPoolDemo
 * @Description
 * @Author yangkang
 * @Date 2020/3/30 17:44
 * @Version 1.0
 **/
public class FixedThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         *  核心线程和最大线程数都是 5；
         *  keepAliveTime 为 0ms，表示当前线程池 线程总数大于核心线程数时，终止多余的空闲线程的时间
         *  LinkedBlockingQueue：这个队列是链式结构，所以是无边界的。可以容纳无数个任务。
         */
        ExecutorService service1 = newFixedThreadPool(5);
        /**
         *  maximumPoolSize：线程允许的最大线程数。  MAX_VALUE (无限大)，
         * 也就是说，只要有任务并且其他线程都在活跃态，就会开启一个新的线程 （因为没有上限）
         * 而当有空闲的线程的时候，就会去调用空闲线程执行任务。
         */
        ExecutorService service2 = newCachedThreadPool();
        ExecutorService service3 = newScheduledThreadPool(10);
        /**
         * 自定义线程池
         */
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4,20,
                1, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));

        for (int i = 0; i < 5; i++) {
            Future<Integer> task = service1.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println("执行线程:" + Thread.currentThread().getName());
                    return 1;
                }
            });
            System.out.println("第" + i + "次计算,结果:" + task.get());

        }
    }
}
