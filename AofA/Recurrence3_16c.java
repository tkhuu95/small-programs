/*
 * Name:         Thomas Khuu
 * Date:         5-05-17
 * Last updated: 5-05-17
 *
 * An Introduction to the Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 3.16c
 *  -originally solved in August 2016 with generating functions
 *
 * % java Recurrence3_16c 23
 *    Original recurrence relation
 *    -5025499.0
 *    ----------------------------
 *    Solution from simplified version
 *    -5025499.000000005
 *
 * % java Recurrence3_16c 534
 *    Original recurrence relation
 *    1.9472337523703204E160
 *    ----------------------------
 *    Solution from simplified version
 *    1.9472337523700704E160
 */

package edu.princeton.cs.algs4;

import edu.princeton.cs.algs4.StdOut;
import org.apache.commons.math3.complex.Complex;

public class Recurrence3_16c implements Sequence {
    
    private final double[] A;
    
    public Recurrence3_16c(int maxN) {
        A = new double[maxN + 1];
        A[0] = 0.0; A[1] = 1.0;
        
        for (int N = 2; N <= maxN; N++)
            A[N] = 3*A[N - 1] - 4*A[N - 2];
    }
    
    public double simplified(int N) {
        Complex one = new Complex(1.0, 0.0);
        Complex three = new Complex(3.0, 0.0);
        Complex seven_im = new Complex(0.0, Math.sqrt(7));
        
        // 1/sqrt(-7)
        Complex a = one.divide(seven_im);
        
        // ( (3 + sqrt(-7)) / 2 )^N
        Complex b = three.add(seven_im).divide(2).pow(1.0*N);
        
        // ( (3 - sqrt(-7)) / 2 )^N
        Complex c = three.subtract(seven_im).divide(2).pow(1.0*N);
        
        Complex x = a.multiply(b).subtract(a.multiply(c));
        return x.getReal();
    }
    
    public double eval(int N) {
        return A[N];
    }
    
    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        Recurrence3_16c r = new Recurrence3_16c(maxN);
        
        StdOut.println("Original recurrence relation");
        StdOut.println(r.eval(maxN));
        
        StdOut.println("----------------------------");
        StdOut.println("Solution from simplified version");
        StdOut.println(r.simplified(maxN));
        
        /*StdOut.println();
        StdOut.printf("%5s %10s %12s\n", "N", "eval", "simplified");
        StdOut.println("---------------------------------");
        for (int N = 0; N <= maxN; N++)
            StdOut.printf("%5d %10.2e %10.2e\n", N, r.eval(N), r.simplified(N));*/
    }
}
