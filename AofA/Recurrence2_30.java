/*
 * Name: Thomas Khuu
 * Date: 4-7-17
 * Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 2.30
 *  -originally solved in August 2016 using Theorerm 2.2
 * 
 * java Recurrence2_30 57
 *  Original recurrence relation
 *  57.0
 *  ----------------------------
 *  Solution from simplified version
 *  57.0
 *  
 * java Recurrence2_30 570
 *  Original recurrence relation
 *  570.0
 *  ----------------------------
 *  Solution from simplified version
 *  570.0
 *
 * java Recurrence2_30 2034
 *  Original recurrence relation
 *  2034.0
 *  ----------------------------
 *  Solution from simplified version
 *  2034.0
 */
package edu.princeton.cs.algs4;

import edu.princeton.cs.algs4.StdOut;

public class Recurrence2_30 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] A = new double[N + 1];
        A[1] = 1.0;
        for (int i = 2; i <= N; i++)
            A[i] = 2.0*A[i - 1] - A[i - 2];
        StdOut.println("Original recurrence relation");
        StdOut.println(A[N]);
        
        StdOut.println("----------------------------");
        StdOut.println("Solution from simplified version");
        StdOut.println((double)(N));
    }
}
