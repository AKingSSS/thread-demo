package _04_tongxin;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ConditionDemo
 * @Description
 * @Author yangkang
 * @Date 2020/3/30 20:56
 * @Version 1.0
 **/
public class ConditionDemo {

    private final ReentrantLock lock = new ReentrantLock();
    /**
     * 获得指定Lock对象对应的Condition
     */
    private final Condition cond = lock.newCondition();

    private static Integer i = 0;

    // 打印奇数
    public void odd() {
        //加锁
        lock.lock();
        try {
            while (i < 10) {
                if (i % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                    cond.signalAll();
                } else {
                    cond.await();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    // 打印偶数
    public void even() {
        //加锁
        lock.lock();
        try {
            while (i < 10) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                    cond.signalAll();
                } else {
                    cond.await();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();
        Thread t1 = new Thread(() -> conditionDemo.odd(), "线程1");
        Thread t2 = new Thread(() -> conditionDemo.even(), "线程2");
        t1.start();
        t2.start();
    }
}
