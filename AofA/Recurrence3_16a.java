/*
 * Name:         Thomas Khuu
 * Date:         4-16-17
 * Last updated: 4-27-17
 *
 * An Introduction to the Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 3.16a
 *  -originally solved in August 2016 with generating functions
 * 
 * % java Recurrence3_16a 123
 *    Original recurrence relation
 *    9.703855619537936E57
 *    ----------------------------
 *    Solution from simplified version
 *    9.703855619537929E57
 *
 * % java Recurrence3_16a 200
 *    Original recurrence relation
 *    -5.3122797775174974E94
 *    ----------------------------
 *    Solution from simplified version
 *    -5.312279777517496E94
 *  
 * % java Recurrence3_16a 321
 *    Original recurrence relation
 *    2.8638664428678256E152
 *    ----------------------------
 *    Solution from simplified version
 *    2.863866442867825E152
 */
package edu.princeton.cs.algs4;

import edu.princeton.cs.algs4.StdOut;
import java.lang.Math;

public class Recurrence3_16a implements Sequence {
    
    private final double[] A;
    
    public Recurrence3_16a(int maxN) {
        A = new double[maxN + 1];
        A[0] = 0.0; A[1] = 1.0;
        
        for (int N = 2; N <= maxN; N++)
            A[N] = -A[N - 1] + 6.0*A[N - 2];
    }
    
    public double simplified(int N) {
        return (1.0/5)*(-Math.pow(-3.0, N) + Math.pow(2.0, N));
    }
    
    public double eval(int N) {
        return A[N];
    }
    
    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        Recurrence3_16a r = new Recurrence3_16a(maxN);
        
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
