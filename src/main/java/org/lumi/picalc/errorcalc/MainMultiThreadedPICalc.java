package org.lumi.picalc.errorcalc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John Tsantilis (A.K.A lumi) on 22/12/2015.
 */
public class MainMultiThreadedPICalc {
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("main");
        int np;
        int i, ns=80;

        List<MultiThreadSimulation> sims = new ArrayList<>();

        long start = System.nanoTime();

        for (i=0;i<ns;i++)
            sims.add(new MultiThreadSimulation((50000),"PI" + i, tg));

        i=0;
        while (i<sims.size()) {
            np = Runtime.getRuntime().availableProcessors();
            /*do we have available CPUs?*/
            if (tg.activeCount()<np) {
                MultiThreadSimulation sim = sims.get(i);
                sim.start();
                i++;

            }
            else
                try {
                    Thread.sleep(100);

                } /*wait 0.1 second before checking again*/
                catch (InterruptedException e) {
                    e.printStackTrace();

                }

        }


		/*wait for threads to finish*/
        while(tg.activeCount()>0) {
            try {
                Thread.sleep(100);

            }
            catch (InterruptedException e) {
                e.printStackTrace();

            }

        }

		/*sum up errors*/
        double sum=0;
        for (i=0;i<sims.size();i++) {
            MultiThreadSimulation sim = sims.get(i);
            sum+=sim.getError();

        }

        long end  = System.nanoTime();

        System.out.printf("Average error is %g\n", sum/sims.size());
        System.out.printf("MultiThreadSimulation took %.2g seconds\n", (double)(end-start)/1e9);

    }

}
