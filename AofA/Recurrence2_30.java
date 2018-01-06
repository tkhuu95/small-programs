/*
 * Name:         Thomas Khuu
 * Date:         4-7-17
 * Last updated: 1-6-18
 *
 * An Introduction to the Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 2.30
 *  -originally solved in August 2016 using Theorerm 2.2
 * 
 * % java Recurrence2_30 57
 *    Original recurrence relation
 *    57.0
 *    ----------------------------
 *    Solution from simplified version
 *    57.0
 *  
 * % java Recurrence2_30 570
 *    Original recurrence relation
 *    570.0
 *    ----------------------------
 *    Solution from simplified version
 *    570.0
 *
 * % java Recurrence2_30 2034
 *    Original recurrence relation
 *    2034.0
 *    ----------------------------
 *    Solution from simplified version
 *    2034.0
 */
package AofA;

import edu.princeton.cs.algs4.StdOut;

public class Recurrence2_30 implements Sequence {
    
    private final double[] A;
    
    public Recurrence2_30(int maxN) {
        A = new double[maxN + 1];
        A[0] = 0.0; A[1] = 1.0;
        
        for (int N = 2; N <= maxN; N++)
            A[N] = 2.0*A[N - 1] - A[N - 2];
    }
    
    public double simplified(int N) {
        return N*1.0;
    }
    
    public double eval(int N) {
        return A[N];
    }
    
    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        Recurrence2_30 r = new Recurrence2_30(maxN);
        
        StdOut.println("Original recurrence relation");
        StdOut.println(r.eval(maxN));
        
        StdOut.println("----------------------------");
        StdOut.println("Solution from simplified version");
        StdOut.println(r.simplified(maxN));
        
        /*StdOut.println("----------------------------");
        for (int N = 0; N <= maxN; N += 2)
            StdOut.printf("%9d %9.2f %9.2f\n", N, r.eval(N), r.simplified(N));*/
    }
}
