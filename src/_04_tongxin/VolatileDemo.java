package _04_tongxin;

/**
 * @ClassName VolatileDemo
 * @Description
 * @Author yangkang
 * @Date 2020/3/30 20:36
 * @Version 1.0
 **/
public class VolatileDemo implements Runnable{
    private static volatile Boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println("Python大星");
        }
        System.out.println("线程结束");
    }

    public static void main(String[] args) {
        VolatileDemo volatileDemo = new VolatileDemo();
        Thread thread = new Thread(volatileDemo);
        thread.start();
        try {
            Thread.sleep(5);
            flag = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
