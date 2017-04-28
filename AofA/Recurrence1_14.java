/*
 * Name:         Thomas Khuu
 * Date:         4-7-17
 * Last updated: 4-27-17
 *
 * An Introduction to the Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 1.14
 *  -originally solved in August 2016 with generating functions
 * 
 * % java Recurrence1_14 50
 *    Original recurrence relation
 *    50.0
 *    -----------------------
 *    Intermediate step version
 *    50.00000000000004
 *    -----------------------
 *    Solution from simplified version 
 *    50
 *
 * % java Recurrence1_14 1249
 *    Original recurrence relation
 *    1249.0
 *    -----------------------
 *    Intermediate step version
 *    1248.9999999999952
 *    -----------------------
 *    Solution from simplified version
 *    1249.0
 */
package edu.princeton.cs.algs4;

import edu.princeton.cs.algs4.StdOut;

public class Recurrence1_14 implements Sequence {
    
    private final double[] A;
    
    public Recurrence1_14(int maxN) {
        A = new double[maxN + 1];
        A[0] = 0.0;
        double sum;
        
        for (int N = 1; N <= maxN; N++) {
            sum = 0;
            for (int j = 1; j <= N; j++)
                sum += A[j - 1];
            A[N] = 1.0 + (2.0 / N) * sum;
        }
    }
    
    public double simplified(int N) {
        
        // Intermediate step version
        StdOut.println("-----------------------");
        StdOut.println("Intermediate step version");
        double[] B = new double[N + 1];
        for (int i = 1; i <= N; i++)
            B[i] = (1.0 / i) + ((i + 1.0) / i) * B[i - 1];
        StdOut.println(B[N]);
        
        StdOut.println("-----------------------");
        StdOut.println("Solution from simplified version");
        return (double) (N);
    }
    
    public double eval(int N) {
        return A[N];
    }
    
    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        Recurrence1_14 r = new Recurrence1_14(maxN);
        
        StdOut.println("Original recurrence relation");
        StdOut.println(r.eval(maxN));
        
        StdOut.println(r.simplified(maxN));
        
        /*StdOut.println("----------------------------");
        for (int N = 0; N <= maxN; N++)
            StdOut.printf("%9d %9.2f %9.2f\n", N, r.eval(N), r.simplified(N));*/
    }
}
