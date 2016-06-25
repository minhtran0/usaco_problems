/*
ID: thuba201
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

public class gift1 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("gift1.in"));
        PrintWriter out = new PrintWriter(new File("gift1.out"));

        int size = Integer.parseInt(sc.nextLine());
        String[] n = new String[size];
        Map<String, Integer> p = new HashMap<String, Integer>();

        for (int i = 0; i < size; i++) {
        	String line = sc.nextLine();
        	p.put(line, 0);
        	n[i] = line;
        }
        for (int i = 0; i < size; i++) {
        	String name = sc.nextLine();
        	String[] data = sc.nextLine().split("\\s+");
        	int a = Integer.parseInt(data[0]);
        	int b = Integer.parseInt(data[1]);
        	p.put(name, p.get(name) - a);
        	for (int j = 0; j < b; j++) {
        			String receiver = sc.nextLine();
        			if (b != 0)
        				p.put(receiver, p.get(receiver) + a/b);
        		}
        	if (b != 0)
        	if (a*1.0/b != (int)a/b) {
        		p.put(name, p.get(name) + a-(int)(a/b)*b);
        	}
        }

        for (String elem : n) {
        	out.println(elem + " " + p.get(elem));
        }

        out.close();
	}
}