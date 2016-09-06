package org.lumi.picalc.simpleexamp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by John Tsantilis (A.K.A lumi) on 22/12/2015.
 */
public class SimpleThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 50; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);

        }
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("Finished all threads");

    }

}
