package org.lumi.picalc;

/**
 * Created by John Tsantilis (A.K.A lumi) on 29/12/2015.
 */
public class MyThread extends Thread {
    boolean negative = true;
    double pi; // Initializes to 0.0, by default

    @Override
    public void run () {
        for (int i = 3; i < 1000000000; i += 2) {
            if (negative)
                pi -= (1.0 / i);
            else
                pi += (1.0 / i);

            negative = !negative;

        }
        pi += 1.0;
        pi *= 4.0;
        System.out.println ("Finished calculating PI");

    }

}
