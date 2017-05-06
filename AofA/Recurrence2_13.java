/*
 * Name:         Thomas Khuu
 * Date:         4-7-17
 * Last updated: 5-6-17
 *
 * An Introduction to the Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 2.13
 *  -originally solved in August 2016 by iteration
 * 
 * % java Recurrence2_13 65
 *    Original recurrence relation
 *    33.5
 *    ----------------------------
 *    Solution from simplified version
 *    33.5
 *  
 * % java Recurrence2_13 570
 *    Original recurrence relation
 *    286.0
 *    ----------------------------
 *    Solution from simplified version
 *    286.0
 *
 * % java Recurrence2_13 1123
 *    Original recurrence relation
 *    562.5
 *    ----------------------------
 *    Solution from simplified version
 *    562.5
 */
package edu.princeton.cs.algs4;
import edu.princeton.cs.algs4.StdOut;

public class Recurrence2_13 implements Sequence {
    
    private final double[] A;
    
    public Recurrence2_13(int maxN) {
        A = new double[maxN + 1];
        A[0] = 1.0;
        
        for (int N = 1; N <= maxN; N++)
            A[N] = (N/(N + 1.0))*A[N - 1] + 1;
    }
    
    public double simplified(int N) {
        return N/2.0 + 1;
    }
    
    public double eval(int N) {
        return A[N];
    }
    
    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        Recurrence2_13 r = new Recurrence2_13(maxN);
        
        StdOut.println("Original recurrence relation");
        StdOut.println(r.eval(maxN));
        
        StdOut.println("----------------------------");
        StdOut.println("Solution from simplified version");
        StdOut.println(r.simplified(maxN));
        
        /*StdOut.println();
        StdOut.printf("%5s %9s %12s\n", "N", "eval", "simplified");
        StdOut.println("----------------------------");
        for (int N = 0; N <= maxN; N++)
            StdOut.printf("%5d %9.2f %9.2f\n", N, r.eval(N), r.simplified(N));*/
    }
}
