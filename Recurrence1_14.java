/*
 * Name: Thomas Khuu
 * Date: 4-7-17
 * Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 1.14
 *  -originally solved in August 2016 with generating functions
 * 
 * java Recurrence1_14 50
 *  Original recurrence relation
 *  50.0
 *  -----------------------
 *  Simplified version
 *  50.00000000000004
 *  -----------------------
 *  Solution -> N = 50
 *
 * java Recurrence1_14 100
 *  Original recurrence relation
 *  100.0
 *  -----------------------
 *  Simplified version
 *  100.00000000000007
 *  -----------------------
 *  Solution -> N = 100
 */
package edu.princeton.cs.algs4;
import edu.princeton.cs.algs4.StdOut;

public class Recurrence1_14 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] A = new double[N + 1];
        double sum;
        for (int i = 1; i <= N; i++) {
            sum = 0;
            for (int j = 1; j <= i; j++)
                sum += A[j - 1];
            A[i] = 1.0 + (2.0 / i) * sum;
        }
        StdOut.println("Original recurrence relation");
        StdOut.println(A[N]);
        
        StdOut.println("-----------------------");
        StdOut.println("Simplified version");
        // simplified intermediate step version
        double[] B = new double[N + 1];
        for (int i = 1; i <= N; i++)
            B[i] = (1.0 / i) + ((i + 1.0) / i) * B[i - 1];
        StdOut.println(B[N]);
        
        StdOut.println("-----------------------");
        StdOut.println("Solution -> N = " + N);
    }
}
