/*
 * Name:         Thomas Khuu
 * Date:         4-14-17
 * Last updated: 4-27-17
 * 
 * An Introduction to the Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 2.15
 *  -originally solved in August 2016 by iteration
 * 
 * % java Recurrence2_15 61
 *    Original recurrence relation
 *    460.3367180912611
 *    ----------------------------
 *    Solution from simplified version
 *    460.3367180912612
 *
 * % java Recurrence2_15 123
 *    Original recurrence relation
 *    1091.5779690883476
 *    ----------------------------
 *    Solution from simplified version
 *    1091.5779690883494
 *  
 * % java Recurrence2_15 4246
 *    Original recurrence relation
 *    67368.47511731069
 *    ----------------------------
 *    Solution from simplified version
 *    67368.47511731093
 */
package edu.princeton.cs.algs4;

import edu.princeton.cs.algs4.StdOut;

public class Recurrence2_15 implements Sequence {
    
    private final double[] A;
    
    public Recurrence2_15(int maxN) {
        A = new double[maxN + 1];
        A[0] = 0.0;
        
        for (int N = 1; N <= maxN; N++)
            A[N] = ((N+1.0) / N)*A[N - 1] + 2;
    }
    
    public double simplified(int N) {
        return 2.0 * (N + 1) * (harmonic(N + 1) - 1);
    }
    
    // Sum of the harmonic series
    private double harmonic(int n) {
        double summation = 0;
        for (int i = 1; i <= n; i++)
            summation += 1.0/i;
        return summation;
    }
    
    public double eval(int N) {
        return A[N];
    }
    
    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        Recurrence2_15 r = new Recurrence2_15(maxN);
        
        StdOut.println("Original recurrence relation");
        StdOut.println(r.eval(maxN));
        
        StdOut.println("----------------------------");
        StdOut.println("Solution from simplified version");
        StdOut.println(r.simplified(maxN));
        
        /*StdOut.println("----------------------------");
        for (int N = 0; N <= maxN; N++)
            StdOut.printf("%9d %9.2f %9.2f\n", N, r.eval(N), r.simplified(N));*/
    }
}
