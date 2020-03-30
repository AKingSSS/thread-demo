package _03_huchitongbu.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.Executors.*;

/**
 * @ClassName ReentrantLockDemo
 * @Description
 * @Author yangkang
 * @Date 2020/3/30 20:20
 * @Version 1.0
 **/
public class ReentrantLockDemo {
    private Lock lock = new ReentrantLock();

    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        } finally {
            lock.unlock(); // 确保释放锁，从而避免发生死锁。
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo lockExample = new ReentrantLockDemo();
        ExecutorService executorService = newCachedThreadPool();
        executorService.execute(() -> lockExample.func());
        executorService.execute(() -> lockExample.func());
    }
}
