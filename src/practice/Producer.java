package practice;

import java.util.List;
import java.util.Random;

/**
 * @program: arithmatictest
 * @description:
 * @author: LLS
 * @create: 2019-02-20 12:32
 **/
public class Producer implements Runnable{
    private List<String> queue;
    private int length;

    public Producer(List<String> queue, int length) {
        this.queue = queue;
        this.length = length;
    }

    @Override
    public void run() {
        try{
            while (!Thread.currentThread().isInterrupted()) {
                Random r = new Random();
                String temp = r.toString();
                synchronized (queue){
                    if (length >= queue.size()) {
                        queue.notifyAll();
                        queue.wait();
                    } else {
                        queue.add(temp);
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
