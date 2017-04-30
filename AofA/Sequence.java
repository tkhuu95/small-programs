/**
 * Name:         Thomas Khuu
 * Date:         4-25-17
 * Last updated: 4-30-17
 * 
 * An interface used by Sedgewick in his book with Flajolet, An Introduction
 * to the Analysis of Algorithms except for the simplified method
 */
public interface Sequence {
    
    // provides the solved simplified version of the recurrence relation
    // and evaluates it at specified N
    public abstract double simplified(int N); 
    
    public abstract double eval(int N);
}
