/* Name: Thomas Khuu
   Date: 2-2-16    */

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class WordFrequencies {
    private Map<String, Integer> map;
    private int max;
    private List<String>[] list;

    public WordFrequencies() {
        map = new HashMap<String, Integer>();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String temp = in.next();
            //replaceAll -> will remove all non-word chars or digits
            String s = temp.toLowerCase().replaceAll("[\\W | \\d]", "");
            
            if (s.equals("")) { continue; }
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
                if (map.get(s) > max) { max = map.get(s); }
            }
        }
        in.close();
        list = (LinkedList<String>[])new LinkedList[max + 1];
    }

    public int maxFrequency() { return max; }

    public void sortDecending() {
        for (int i = 0; i < list.length; i++)
            list[i] = new LinkedList<String>();

        for (String s : map.keySet())
            list[map.get(s)].add(s);

        //goes through the ArrayList backwards
        //removes the Node until specified index has no more Nodes
        //skips indices that have nothing
        int i = maxFrequency();
        int index = list[i].size();
        while (i > 0) {
            if(list[i].isEmpty()) { 
                i--; 
                index = list[i].size() - 1;
                if (index < 0) { continue; }
            }
            else { index--; }
            System.out.println(list[i].remove(index) + "\t" + i);
        }
    }

    // test
    public static void main(String[] args) {
        WordFrequencies a = new WordFrequencies();
        a.sortDecending();
    }
}
