/*
 * Name:         Thomas Khuu
 * Date:         5-03-17
 * Last updated: 1-6-18
 *
 * An Introduction to the Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 3.17
 *  -originally solved in August 2016 with generating functions
 * 
 * % java Recurrence3_17 163
 *    Original recurrence relation
 *    1.1692013098647223E49
 *    ----------------------------
 *    Solution from simplified version
 *    1.1692013098647223E49
 *
 * % java Recurrence3_17 688
 *    Original recurrence relation
 *    1.2842128665889584E207
 *    ----------------------------
 *    Solution from simplified version
 *    1.2842128665889584E207
 */
 
package AofA;

import edu.princeton.cs.algs4.StdOut;

public class Recurrence3_17 implements Sequence {
    
    private final double[] A;
    
    public Recurrence3_17(int maxN) {
        A = new double[maxN + 1];
        A[0] = 1.0; A[1] = 2.0; A[2] = 4.0;
        
        for (int N = 3; N <= maxN; N++)
            A[N] = 5*A[N - 1] - 8*A[N - 2] + 4*A[N - 3];
    }
    
    public double simplified(int N) {
        return Math.pow(2, N);
    }
    
    public double eval(int N) {
        return A[N];
    }
    
    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        Recurrence3_17 r = new Recurrence3_17(maxN);
        
        StdOut.println("Original recurrence relation");
        StdOut.println(r.eval(maxN));
        
        StdOut.println("----------------------------");
        StdOut.println("Solution from simplified version");
        StdOut.println(r.simplified(maxN));
        
        /*StdOut.println();
        StdOut.printf("%5s %9s %12s\n", "N", "eval", "simplified");
        StdOut.println("---------------------------------");
        for (int N = 0; N <= maxN; N++)
            StdOut.printf("%5d %10.2e %10.2e\n", N, r.eval(N), r.simplified(N));*/
    }
}
