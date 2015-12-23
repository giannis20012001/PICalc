package org.lumi.picalc;

/**
 * Created by John Tsantilis (A.K.A lumi) on 22/12/2015.
 */
public class MainSingleThreadedPICalc {
    public static void main(String[] args) {
        double sum = 0;
        int ns=1000;   /*number of computations*/

                /*sample 50,000 x 1,000 points*/
        SingleThreadSimulation sim = new SingleThreadSimulation(50000);

        long start = System.nanoTime();
        for (int i=0;i<ns;i++) {
            sim.computePI();
            sum += sim.getError();

        }

        long end  = System.nanoTime();
        System.out.printf("Average error is %g\n", sum/ns);
        System.out.printf("SingleThreadSimulation took %.2g seconds\n", (double)(end-start)/1e9);

    }

}
