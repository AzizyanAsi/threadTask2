package threadTask2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueMain {
    public static Queue<String> pQueue = new PriorityQueue<String>();


    public static void main(String[] args) {
        Thread consumer = new Thread(new Consumer("consumer"));
        consumer.start();
        Thread producer = new Thread(new Producer("producer"));
        producer.start();
        try {
            consumer.join(2000);
            producer.join(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.interrupt();
        System.out.println(pQueue);
    }
}
