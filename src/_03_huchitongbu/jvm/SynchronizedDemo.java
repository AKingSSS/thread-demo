package _03_huchitongbu.jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.*;

/**
 * @ClassName SynchronizedDemo
 * @Description
 * @Author yangkang
 * @Date 2020/3/30 20:13
 * @Version 1.0
 **/
public class SynchronizedDemo {
    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        // 它只作用于同一个对象，如果调用两个对象上的同步代码块，就不会进行同步。
       /* SynchronizedDemo e1 = new SynchronizedDemo();
        ExecutorService executorService = newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e1.func1());*/

        SynchronizedDemo e1 = new SynchronizedDemo();
        SynchronizedDemo e2 = new SynchronizedDemo();
        ExecutorService executorService2 = newCachedThreadPool();
        executorService2.execute(() -> e1.func1());
        executorService2.execute(() -> e2.func1());

    }
}
