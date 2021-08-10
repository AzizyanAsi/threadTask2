package threadTask2;

import static threadTask2.QueueMain.pQueue;

public class Consumer implements Runnable {
    public String name;
    boolean isFirst = true;

    public Consumer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (pQueue) {
            for (int x = 0; x < 10; x++) {
                pQueue.add("element" + x);

                pQueue.notifyAll();

                try {
                    pQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
