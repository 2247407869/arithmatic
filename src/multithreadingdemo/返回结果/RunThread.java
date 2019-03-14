package multithreadingdemo.返回结果;

/**
 * @program: arithmatictest
 * @description: TODO
 * @author: LLS
 * @create: 2019-03-06 20:07
 **/
import java.util.Random;
import java.util.concurrent.TimeUnit;

class RunThread extends Thread {
    private String runLog = "";
    private String name;

    public RunThread(String name) {
        this.name = name;
    }

    public void run() {
        try {
            int time = new Random().nextInt(10);
            System.out.println("sleep "+ time +" second.");
            TimeUnit.SECONDS.sleep(time);
            this.runLog = this.name + time;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getRunLog() {
        return this.runLog;
    }
}