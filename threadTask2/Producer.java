package threadTask2;

import static threadTask2.QueueMain.pQueue;

public class Producer implements Runnable {
    public String name;
    boolean isFirst = true;

    public Producer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (pQueue) {
            while (true) {

                try {
                    pQueue.notifyAll();
                    if (pQueue.isEmpty()) {

                        pQueue.wait();
                    } else {
                        System.out.println(pQueue.poll());

                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

    }
}
