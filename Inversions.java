import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

/**
 * Implementation of both the brute force way and the optimal way
 * of counting inversions.
 * 
 * @author Thomas Khuu
 */
public class Inversions {

    private static long inversionCount;

    // Checking correctness of implementation.
    private static long comparisonCount;    

    /*
     * O(N^2) inversion count.
     */
    public static long bruteForce(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length - 1; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] > a[j]) count++;
        
        return count;
    }

    /*
     * Optimal O(NlogN) inversion count.
     */
    public static long mergeSort(int[] arr) {
        inversionCount = 0;
        comparisonCount = 0;
        int[] a = mergeSort(arr, 0, arr.length);
        assert isSorted(a);

        return inversionCount;
    }

    private static int[] mergeSort(int[] arr, int lo, int hi) {
        if (hi - lo <= 1) {
            int[] temp = new int[1];
            temp[0] = arr[lo];
            return temp; 
        }
        int mid = (hi + lo) / 2;
        int[] b = mergeSort(arr, lo, mid);
        int[] c = mergeSort(arr, mid, hi);
        int[] d = merge(b, c, hi - lo);
        return d;
    }

    private static int[] merge(int[] b, int[] c, int n) {
        int i = 0, j = 0;
        int[] arr = new int[n];

        for (int k = 0; k < n; k++) {
            if (i < b.length && j < c.length) {
                if (b[i] <= c[j]) {
                    arr[k] = b[i++];
                    comparisonCount++;
                } else if (c[j] <= b[i]) {
                    arr[k] = c[j++];
                    // Remaining elements in array b are the number
                    // of inversions left
                    inversionCount += b.length - i;
                    comparisonCount++;
                }
            } else {
                // If 1 of the arrays are done then merge the
                // the other array
                if (i >= b.length) arr[k] = c[j++];
                else               arr[k] = b[i++];
                comparisonCount++;
            }
        }
        return arr;
    }

    /************************************************
      Helper methods below for checking correctness 
    ************************************************/

    private static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1]) return false;
        return true;
    }
    
    private static int[] generate() {
        Random rand = new Random();
        int[] a = new int[rand.nextInt(1000) + 1];
        for (int i = 0; i < a.length; i++)
            a[i] = rand.nextInt(Integer.MAX_VALUE);
        return a;
    }

    /*
     * Exact number of comparisons used by merge sort.
     * (from An Intro to the Analysis of Algorithms by Sedgewick and Flajolet)
     * 
     * X = floor(lgN) for readability
     * N*X + 2N - 2^(X + 1)
     */
    public static void mergeSortCompares(int[] a) {
        int N = a.length;
        mergeSort(a);

        double X = Math.floor(Math.log(N) / Math.log(2));

        double ms = N*X + 2*N - Math.pow(2, X + 1);

        System.out.format("%15d\t%15.1f\n", comparisonCount, ms);
    }

    public static void main(String[] args) throws FileNotFoundException {
/*        Scanner in = new Scanner(new File("array.txt"));
        
        int[] arr = new int[in.nextInt()];
        int i = 0;
        while (in.hasNextInt())
            arr[i++] = in.nextInt();
        System.out.println(mergeSort(arr) + "  " + bruteForce(arr));

        for (int i = 0; i < 1000; i++) {
            int[] a = generate();
            Inversions.mergeSortCompares(a);
        }*/
        
        for (int i = 0; i < 1000; i++) {
            int[] a = generate();
            System.out.format("%10d\t%10d\n", bruteForce(a), mergeSort(a));
        }
    }
}
