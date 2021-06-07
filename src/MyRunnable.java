import java.util.Date;

/**
 * @Auther: Carl
 * @Date: 2021/06/07/16:30
 * @Description:
 */
public class MyRunnable implements Runnable{

    private String command;

    public MyRunnable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "start time: " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + "end time: " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
