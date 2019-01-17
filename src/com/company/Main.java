package com.company;

import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //create threads
        var executionThreads = Executors.newFixedThreadPool(5);

        //define threads
        var t1 = new WorkerThread(0);
        var t2 = new WorkerThread(2);
        var t3 = new WorkerThread(4);
        var t4 = new WorkerThread(6);
        var t5 = new WorkerThread(8);

        // execute all threads
        executionThreads.execute(t1);
        executionThreads.execute(t2);
        executionThreads.execute(t3);
        executionThreads.execute(t4);
        executionThreads.execute(t5);

        //shutdown threads
        executionThreads.shutdown();
        while (!executionThreads.isTerminated()) {

        }

        System.out.println("Finished");
    }
}
