/*
 * Name:         Thomas Khuu
 * Date:         5-05-17
 * Last updated: 5-05-17
 *
 * An Introduction to the Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 2.9
 *  -originally solved in August 2016 by iteration
 * 
 * % java Recurrence2_9 150
 *    Original recurrence relation
 *    8.713837574067621E-5
 *    ----------------------------
 *    Solution from simplified version
 *    8.71383757406762E-5
 *
 * % java Recurrence2_9 923
 *    Original recurrence relation
 *    2.34000234000234E-6
 *    ----------------------------
 *    Solution from simplified version
 *    2.34000234000234E-6
 */

package edu.princeton.cs.algs4;

import edu.princeton.cs.algs4.StdOut;

public class Recurrence2_9 implements Sequence {
    
    private final double[] A;
    
    public Recurrence2_9(int maxN) {
        A = new double[maxN + 1];
        A[0] = 1.0;
        
        for (int N = 1; N <= maxN; N++)
            A[N] = (1.0*N / (N+2))*A[N - 1];
    }
    
    public double simplified(int N) {
        return 2.0/((N + 2)*(N + 1));
    }
    
    public double eval(int N) {
        return A[N];
    }
    
    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        Recurrence2_9 r = new Recurrence2_9(maxN);
        
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
