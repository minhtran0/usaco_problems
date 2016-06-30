/*
ID: thuba201
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

public class milk2 {

    static int[] start, end, union, rank;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("milk2.in"));
        PrintWriter out = new PrintWriter(new File("milk2.out"));
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();

        int n = Integer.parseInt(sc.nextLine());
        start = new int[n];
        end = new int[n];
        union = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split("\\s+");
            map.put(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
            union[i] = i;
        }
        int index = 0;
        for (int i : map.keySet()) {
            start[index] = i;
            end[index] = map.get(i);
            index++;
        }

        milk2 m = new milk2();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (union[j] == i || union[i] == j)  continue;
                if (m.isIncluded(i, j)) {
                    //union[i] = j;
                    m.join(i,j);
                }
            }
        }

        int[] startIdle = new int[n];
        int[] endIdle = new int[n];

        int maxtime = 0;
        for (int i = 0; i < n; i++) {
            int k = 0;
            if (i == union[i]) {
                if (endIdle[i] != 0)    continue;
                k = end[i] - start[i];
                startIdle[i] = start[i];
                endIdle[i] = end[i];
            }
            else {
                int[] result = m.findMax(i, start[i], end[i]);
                k = result[2] - result[1];
                if (endIdle[result[0]] == 0) {
                    startIdle[result[0]] = result[1];
                    endIdle[result[0]] = result[2];
                }
                else if (result[1] <= startIdle[result[0]] &&
                    result[2] >= endIdle[result[0]]) {
                    startIdle[result[0]] = result[1];
                    endIdle[result[0]] = result[2];
                }
            }
            if (k > maxtime) maxtime = k;
        }
        int maxIdle = 0;
        Arrays.sort(startIdle);
        Arrays.sort(endIdle);

        for (int i = n-1; i > 0; i--) {
            if (startIdle[i] == 0 && endIdle[i] == 0)   break;
            if (startIdle[i-1] == 0 && endIdle[i-1] == 0) break;
            int t1 = startIdle[i]-endIdle[i-1];
            if (t1 > maxIdle) {
                maxIdle = t1;
            }
        }
        out.println(maxtime + " " + maxIdle);
        out.close();
    }
    public int[] findMax(int i, int a, int b) {
        int a1 = a, b1 = b;
        if (union[i] == i)  return new int[]{i, a1, b1};
        if (start[union[i]] < a)    a1 = start[union[i]];
        if (end[union[i]] > b)      b1 = end[union[i]];
        return findMax(union[i], a1, b1);
    }
    public boolean isIncluded(int a, int b) {
        if (start[b] > end[a])  return false;
        if (start[a] > end[b])  return false;
        return true;
    }
    public void join(int a, int b) {
        if (rank[a] > rank[b]) {
            union[b] = a;
        }
        if (rank[b] > rank[a]) {
            union[a] = b;
        }
        else if (rank[a] == rank[b]) {
            union[b] = a;
            rank[a]++;
        }
    }
}