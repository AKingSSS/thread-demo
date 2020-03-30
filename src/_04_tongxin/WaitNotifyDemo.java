package _04_tongxin;

/**
 * @ClassName WaitNotifyDemo
 * @Description
 * @Author yangkang
 * @Date 2020/3/30 20:41
 * @Version 1.0
 **/
public class WaitNotifyDemo {
    // 状态锁
    private static Object lock = new Object();
    private static Integer i = 0;

    // 打印奇数
    public void odd() {
        while (i < 10) {
            synchronized (lock) {
                if (i % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // 打印偶数
    public void even() {
        while (i < 10) {
            synchronized (lock) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        /**
         * 当线程执行 wait () 方法时候，会释放当前的锁，然后让出 CPU，进入等待状态。
         * 只有当 notify/notifyAll () 被执行时候，才会唤醒一个或多个正处于等待状态的线程，
         * 然后继续往下执行，直到执行完 synchronized 代码块的代码或是中途遇到 wait () ，再次释放锁。
         */
        WaitNotifyDemo waitNotifyDemo = new WaitNotifyDemo();
        Thread t1 = new Thread(() -> waitNotifyDemo.odd(), "线程1");
        Thread t2 = new Thread(() -> waitNotifyDemo.even(), "线程2");
        t1.start();
        t2.start();
    }
}
