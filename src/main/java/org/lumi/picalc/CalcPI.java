package org.lumi.picalc;

/**
 * Created by John Tsantilis (A.K.A lumi) on 29/12/2015.
 */
public class CalcPI {
    public static void main(String[] args) {
        MyThread mt = new MyThread ();
        mt.start ();
        try {
            mt.join ();

        }
        catch (InterruptedException e) {

        }
        System.out.println ("pi = " + mt.pi);

    }

}
