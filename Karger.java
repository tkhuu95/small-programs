import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Implementation of Karger's minimum cut algorithm using the 
 * adjacency list data structure to represent the graph.
 *
 * @author Thomas Khuu
 */
public class Karger {

    private ArrayList<Integer>[] adjList;

    private ArrayList<Integer> indices;

    private int V;
    
    /**
     * Construct an adjacency list given the scanner object. Assumes the 
     * vertices to be numbered from 1 to V.
     *
     * @param in  the scanner to read input to adjacency list.
     */
    @SuppressWarnings("unchecked")
    public Karger(Scanner in) {

        V = in.nextInt();
        adjList = (ArrayList<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++)
            adjList[v] = new ArrayList<Integer>();
        in.nextLine();

        while (in.hasNextLine()) {
            int[] adj = Arrays.stream(in.nextLine().split("\\s"))
                              .mapToInt(Integer::parseInt).toArray();

            for (int i = 1; i < adj.length; i++)
                adjList[adj[0] - 1].add(adj[i]);
        }
        in.close();

        indices = new ArrayList<Integer>(V);
        for (int v = 0; v < V; v++)
            indices.add(v);
    }

    /**
     * Karger's randomized min-cut algorithm.
     *
     * @return the minimum cut for this graph 
     *         (there may be a chance of not returning actual min).
     */
    @SuppressWarnings("unchecked")
    public int minCut() {
        // Run it a few times to reduce chance of not getting a min cut
        Random rand = new Random();
        int min = Integer.MAX_VALUE;
        for (int c = 0; c < 20; c++) {
            int vCount = V, tempMin = Integer.MAX_VALUE;

            // Clone both array lists due to multiple iterations
            ArrayList<Integer>[] copiedAdj   = copyAdj();
            ArrayList<Integer> copiedIndices = (ArrayList<Integer>) indices.clone();

            while (vCount > 2) {
                // Pick randomly any vertex in adjacency list
                int u = copiedIndices.remove(rand.nextInt(copiedIndices.size()));

                // Shallow clone it then null it in the adjacency list
                ArrayList<Integer> cutVertex = (ArrayList<Integer>) copiedAdj[u].clone();
                copiedAdj[u] = null;

                // Remove v that is adjacent to u in cutVertex and 
                //   remove all u vertices that are adjacent to v in adj list
                int index = rand.nextInt(cutVertex.size());
                int v     = cutVertex.remove(index);
                copiedAdj[v-1].removeIf((Integer x) -> x == (u + 1));
            
                // Remove self loops that can occur before putting back to adj list
                cutVertex.removeIf((Integer x) -> x == v);

                // Copy what is adjacent to vertex u to vertex v
                for (int i : cutVertex)
                    copiedAdj[v-1].add(i);
            
                for (int i = 0; i < copiedAdj.length; i++) {
                    if (copiedAdj[i] != null && i != v-1) {
                        // If vertex u is adjacent to adj list at index i
                        //   then replace all occurences of u with v
                        if (copiedAdj[i].contains(u + 1)) {
                            copiedAdj[i].replaceAll((Integer x) -> x == (u + 1) ? v : x);
                        } 
                    }   
                }
                vCount--;
            }

            // Find the first non-null array list and 
            //   that is the number of "minimum" cuts for now
            for (int v = 0; v < V; v++) {
                if (copiedAdj[v] != null) {
                    tempMin = copiedAdj[v].size();
                    break;
                }
            }

            if (tempMin < min) min = tempMin;
        }
        return min;
    }

    @SuppressWarnings("unchecked")
    private ArrayList<Integer>[] copyAdj() {
        ArrayList<Integer>[] temp = (ArrayList<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++)
            temp[v] = (ArrayList<Integer>) adjList[v].clone();

        return temp;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Karger k = new Karger(new Scanner(new File("karger.txt")));
        System.out.println(k.minCut());
    }
}
