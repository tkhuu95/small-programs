/*
 * Name:         Thomas Khuu
 * Date:         5-29-17
 * Last updated:
 *
 * An Introduction to the Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 2.10
 *  - Solved with generating functions on 5-29-17
 * 
 * % java Recurrence2_10 121
 *    Original recurrence relation
 *    -60.0
 *    ----------------------------
 *    Solution from simplified version
 *    -60.0
 * 
 * % java Recurrence2_10 543
 *    Original recurrence relation
 *    -271.0
 *    ----------------------------
 *    Solution from simplified version
 *    -271.0
 * 
 * % java Recurrence2_10 938
 *    Original recurrence relation
 *    470.0
 *    ----------------------------
 *    Solution from simplified version
 *    470.0
 */
package AofA;

import edu.princeton.cs.algs4.StdOut;

public class Recurrence2_10 implements Sequence {
    
    private final double[] A;
    
    public Recurrence2_10(int maxN) {
        A = new double[maxN + 1];
        A[0] = 1.0;
        
        for (int N = 1; N <= maxN; N++)
            A[N] = A[N - 1] + Math.pow(-1, N)*N;
    }
    
    public double simplified(int N) {
        double alt_one = Math.pow(-1, N);
        return -0.25*alt_one + (0.5*alt_one*(N + 1)) + 0.75;
    }
    
    public double eval(int N) {
        return A[N];
    }
    
    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        Recurrence2_10 r = new Recurrence2_10(maxN);
        
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
