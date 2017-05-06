/*
 * Name:         Thomas Khuu
 * Date:         4-28-17
 * Last updated: 5-01-17
 *
 * An Introduction to the Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 2.31/Problem 3.16d
 *  -originally solved in August 2016 with generating functions
 *  
 * Multiples of 6 will give negative numbers very close to 0.0
 * and rounding will produce -0.0
 *
 * % java Recurrence2_31 128
 *    Original recurrence relation
 *    1.0
 *    ----------------------------
 *    Solution from simplified version
 *    1.0000000000000087
 *
 * % java Recurrence2_31 598
 *    Original recurrence relation
 *    -1.0
 *    ----------------------------
 *    Solution from simplified version
 *    -0.9999999999999628
 */
 
package edu.princeton.cs.algs4;

import edu.princeton.cs.algs4.StdOut;
import org.apache.commons.math3.complex.Complex;

public class Recurrence2_31 implements Sequence {
    
    private final double[] A;
    
    public Recurrence2_31(int maxN) {
        A = new double[maxN + 1];
        A[0] = 0.0; A[1] = 1.0;
        
        for (int N = 2; N <= maxN; N++)
            A[N] = A[N - 1] - A[N - 2];
    }
    
    public double simplified(int N) {
        Complex one = new Complex(1.0, 0.0);
        Complex three_im = new Complex(0.0, Math.sqrt(3));
        
        // 1/sqrt(-3)
        Complex a = one.divide(three_im);
        
        // ( (1 + sqrt(-3)) / 2 )^N
        Complex b = one.add(three_im).divide(2).pow(1.0*N);
        
        // ( (1 - sqrt(-3)) / 2 )^N
        Complex c = one.subtract(three_im).divide(2).pow(1.0*N);
        
        Complex x = a.multiply(b).subtract(a.multiply(c));
        return x.getReal();
    }
    
    public double eval(int N) {
        return A[N];
    }
    
    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        Recurrence2_31 r = new Recurrence2_31(maxN);
        
        StdOut.println("Original recurrence relation");
        StdOut.println(r.eval(maxN));
        
        StdOut.println("----------------------------");
        StdOut.println("Solution from simplified version");
        StdOut.println(r.simplified(maxN));
        
        /*StdOut.println();
        StdOut.printf("%5s %9s %12s\n", "N", "eval", "simplified");
        StdOut.println("---------------------------------");
        for (int N = 0; N <= maxN; N++)
            StdOut.printf("%5d %9.2f %9.2f\n", N, r.eval(N), r.simplified(N));*/
    }
}
