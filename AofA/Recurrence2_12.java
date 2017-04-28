/*
 * Name:         Thomas Khuu
 * Date:         4-7-17
 * Last updated: 4-27-17
 *
 * An Introduction to the Analysis of Algorithms by Sedgewick and Flajolet
 * Problem 2.12
 *  -originally solved in August 2016 with generating functions
 * 
 * % java Recurrence2_12 50
 *    Original recurrence relation
 *    1.125899906842623E15
 *    ----------------------------
 *    Solution from simplified version
 *    1.125899906842623E15
 *  
 * % java Recurrence2_12 342
 *    Original recurrence relation
 *    8.958978968711217E102
 *    ----------------------------
 *    Solution from simplified version
 *    8.958978968711217E102
 *
 * % java Recurrence2_12 1000
 *   Original recurrence relation
 *   1.0715086071862673E301
 *   ----------------------------
 *   Solution from simplified version
 *   1.0715086071862673E301
 */
package edu.princeton.cs.algs4;
import edu.princeton.cs.algs4.StdOut;
import java.lang.Math;

public class Recurrence2_12 implements Sequence {
    
    private final double[] A;
    
    public Recurrence2_12(int maxN) {
        A = new double[maxN + 1];
        A[0] = 0.0; A[1] = 1.0;
        
        for (int N = 2; N <= maxN; N++)
            A[N] = 2*A[N - 1] + 1;
    }
    
    public double simplified(int N) {
        return Math.pow(2, N) - 1;
    }
    
    public double eval(int N) {
        return A[N];
    }
    
    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        Recurrence2_12 r = new Recurrence2_12(maxN);
        
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
