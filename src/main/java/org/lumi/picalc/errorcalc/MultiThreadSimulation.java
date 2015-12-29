package org.lumi.picalc.errorcalc;

import java.util.Random;

/**
 * Created by John Tsantilis (A.K.A lumi) on 22/12/2015.
 */
public class MultiThreadSimulation extends Thread {
    protected double result;			/*result*/
    protected double error;				/*error in percent*/

    protected int nk;
    Random rnd;

    double getResult() {
        return result;

    }
    double getError() {
        return error;

    }

    MultiThreadSimulation(int nk, String name, ThreadGroup tg) {
        super(tg,name);
        this.nk = nk;
        rnd = new java.util.Random();

    }

    @Override
    public void run() {
        computePI();

    }

    /*CalculatesPI by taking nk*1000 sample points*/
    void computePI() {
        double x,y;
        double r;
        int i,j=0;
        int count=0;

        for (i=0;i<nk;i++)
            for (j=0;j<1000;j++) {
				/*select random point*/
                x = rnd.nextDouble();
                y = rnd.nextDouble();

                r=Math.sqrt(x*x+y*y);
                if (r<=1.0)
                    count++;
            }

        result = 4*count/(double)(nk*j);
        error = 100*Math.abs(result-Math.PI)/Math.PI;
        System.out.printf(" nk = %d:\t pi = %g,\t error = %.2g%%\n", nk,result,error);

    }

}
