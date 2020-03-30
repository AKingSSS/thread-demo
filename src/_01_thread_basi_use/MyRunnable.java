package _01_thread_basi_use;

/**
 * @ClassName MyRunnable
 * @Description
 * @Author yangkang
 * @Date 2020/3/30 16:26
 * @Version 1.0
 **/
public class MyRunnable implements Runnable{
    private String name;
    public MyRunnable(String name) {
        this.name = name;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println(this.name + ":hello world");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable("Python大星");
        Thread thread = new Thread(myRunnable);
        thread.start();
//        thread.start(); // 不能多次 start
    }
}
