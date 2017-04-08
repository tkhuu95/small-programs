/*
 * Name: Thomas Khuu
 * Date: 4-7-17
 * Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 2.12
 *  -originally solved in August 2016 with generating functions
 * 
 * java Recurrence2_12 50
 *  Original recurrence relation
 *  1.125899906842623E15
 *  ----------------------------
 *  Solution from simplified version
 *  1.125899906842623E15
 *  
 * java Recurrence2_12 1000
 *  Original recurrence relation
 *  1.0715086071862673E301
 *  ----------------------------
 *  Solution from simplified version
 *  1.0715086071862673E301
 */
package edu.princeton.cs.algs4;
import edu.princeton.cs.algs4.StdOut;
import java.lang.Math;

public class Recurrence2_12 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] A = new double[N + 1];
        A[1] = 1.0;
        for (int i = 2; i <= N; i++)
            A[i] = 2*A[i - 1] + 1;
        StdOut.println("Original recurrence relation");
        StdOut.println(A[N]);
        
        StdOut.println("----------------------------");
        double A_N = Math.pow(2, N) - 1;
        StdOut.println("Solution from simplified version");
        StdOut.println(A_N);
    }
}
