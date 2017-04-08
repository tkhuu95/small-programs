/*
 * Name: Thomas Khuu
 * Date: 4-7-17
 * Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 2.13
 *  -originally solved in August 2016 by iteration
 * 
 * java Recurrence2_13 65
 *  Original recurrence relation
 *  3.6893488147419103E19
 *  ----------------------------
 *  Solution from simplified version
 *  3.6893488147419103E19
 *  
 * java Recurrence2_13 570
 *  Original recurrence relation
 *  3.8645375230172583E171
 *  ----------------------------
 *  Solution from simplified version
 *  3.8645375230172583E171
 */
package edu.princeton.cs.algs4;
import edu.princeton.cs.algs4.StdOut;

public class Recurrence2_13 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] A = new double[N + 1];
        A[0] = 1.0;
        for (int i = 1; i <= N; i++)
            A[i] = (i / (i + 1))*A[i - 1] + 1;
        StdOut.println("Original recurrence relation");
        StdOut.println(A[N]);
        
        StdOut.println("----------------------------");
        double A_N = N/2 + 1;
        StdOut.println("Solution from simplified version");
        StdOut.println(A_N);
    }
}
