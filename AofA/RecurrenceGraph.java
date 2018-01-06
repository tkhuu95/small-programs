/*
 * Name:         Thoams Khuu
 * Date:         5-01-17
 * Last updated: 5-03-17
 *
 * Simple program that graphs the recurrence relations to see the growth 
 * using StdDraw.java from Princeton. 
 */
 
package AofA;
  
import edu.princeton.cs.algs4.StdDraw;

import java.awt.Color;

public class RecurrenceGraph {
    public static void plot(Sequence s, int maxN, Color color) {
        StdDraw.setPenColor(color); StdDraw.setPenRadius(0.0066);
        
        double maxY = Double.MIN_VALUE, minY = Double.MAX_VALUE;
        for (int N = 0; N < maxN; N++) {
            if (s.eval(N) > maxY) maxY = s.eval(N);
            if (s.eval(N) < minY) minY = s.eval(N);
        }
    
        StdDraw.setXscale(0.0, maxN + 10.0);
        StdDraw.setYscale(minY, maxY + 10.0);
        for (int N = 0; N < maxN; N++)
            StdDraw.point(1.0*N, s.eval(N));
    }
    
    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        Recurrence1_14 a = new Recurrence1_14(maxN);
        RecurrenceGraph.plot(a, maxN, Color.ORANGE);
    }
}
