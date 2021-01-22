package com.company;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    //Queue used for producer-consumer problem Queue<Integer> arr = new LinkedList<>(); ;

    int capacity=3;
    Queue<Integer> arr = new LinkedList<>();

    public void produce() throws InterruptedException {
        int value = 0;

        while(true)
        {
            synchronized (this)
            {
                // producer thread waits while list is full while(arr.size()==capacity)
                while(arr.size()==capacity)
                {
                    System.out.println("\nProducer is Waiting.... \n");
                    wait();
                }

                System.out.println("Producer produced : "+ value);

                arr.add(value++);

                // notifies the consumer thread that now it can start consuming notify();
                notifyAll();
                // sleep
                Thread.sleep(1000);
            }
        }
    }

    public void consumes() throws InterruptedException {
        while(true) {

            synchronized (this) {

                // consumer thread waits while list is empty while(arr.isEmpty())

                while(arr.isEmpty()) {
                    System.out.println("\nConsumer is Waiting.... \n");
                    wait();
                }

                int consumedValue = arr.remove();

                System.out.println("Consumer Consumed : "+ consumedValue);

                // Wake up producer thread notify();
                notifyAll();
                //sleep
                Thread.sleep(500);
            }
        }
    }



    public static void main(String[] args) throws InterruptedException
    {
        Main pc = new Main();

        // Create producer thread
        Thread Producer= new Thread(new Runnable() {
            @Override public void run() {
                try {
                    pc.produce();
                }
                catch (InterruptedException e) {
                    System.out.println("Error: "+e); }
            }
        });

        // Create consumer thread
        Thread Consumer= new Thread(new Runnable() {
            @Override public void run() {
                try {
                    pc.consumes();
                }
                catch (InterruptedException e) {
                    System.out.println("Error: "+e); }
            }
        });

        Producer.start();
        Consumer.start();

        // t1 finishes before t2 t1.join();

        Producer.join();
        //Consumer.join();

    }
}

