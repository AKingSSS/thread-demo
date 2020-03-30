package _03_huchitongbu.jvm;

/**
 * @ClassName DeadLockDemo
 * @Description
 * @Author yangkang
 * @Date 2020/3/30 22:27
 * @Version 1.0
 **/
public class DeadLockDemo {
    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (DeadLockDemo.o1){
                    System.out.println("thread 1 get o1");
                    try {
                        Thread.sleep(100);
                        synchronized (DeadLockDemo.o2){
                            System.out.println("thread1 get o2");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (DeadLockDemo.o2){
                    System.out.println("thread 2 get o2");
                    try {
                        Thread.sleep(100);
                        synchronized (DeadLockDemo.o1){
                            System.out.println("thread2 get o1");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
