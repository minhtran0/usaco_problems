/*
ID: thuba201
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.*;

public class milk {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("milk.in"));
        PrintWriter out = new PrintWriter(new File("milk.out"));

        int need, farmers;
        Map<Integer,Integer> map;

        String[] first = sc.nextLine().split("\\s+");
        need = Integer.parseInt(first[0]);
        farmers = Integer.parseInt(first[1]);

        map = new TreeMap<Integer,Integer>();

        for (int i = 0; i < farmers; i++) {
            String[] line = sc.nextLine().split("\\s+");
            if (map.get(Integer.parseInt(line[0])) == null)
            	map.put(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            else 
            	map.put(Integer.parseInt(line[0]), map.get(Integer.parseInt(line[0])) + Integer.parseInt(line[1]));
        }

        int total = 0;

        for (int cost : map.keySet()) {
            if (need == 0) break;
            if (map.get(cost) >= need) {
                total += need * cost;
                break;
            }
            else {
                total += map.get(cost) * cost;
                need -= map.get(cost);
            }
        }
        
        out.println(total);
        out.close();
    }
}