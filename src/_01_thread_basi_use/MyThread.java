package _01_thread_basi_use;

/**
 * @ClassName MyThread
 * @Description
 * @Author yangkang
 * @Date 2020/3/30 16:54
 * @Version 1.0
 **/
public class MyThread extends Thread {
    private String name;
    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        System.out.println("我是" + this.name);
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread("Python大星");
        myThread.start();
    }
}
