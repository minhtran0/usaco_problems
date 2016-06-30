/*
ID: thuba201
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.*;

public class namenum {

	static Set<String> set, set2;
	static PrintWriter out;
	static Map<String,char[]> map;
	static boolean done;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("namenum.in"));
        out = new PrintWriter(new File("namenum.out"));
        Scanner dict = new Scanner(new File("dict.txt"));

        String n = sc.nextLine();
        done = false;

        set = new HashSet<String>();
        set2 = new HashSet<String>();
        map = new HashMap<String,char[]>();
        char counter = 'A';
        for (int i = 2; i <= 9; i++) {
        	 char[] temp = new char[3];
        	 for (int j = 0; j < 3; j++) {
        	 	temp[j] = counter;
        	 	counter = (char)(counter + 1);
        	 	if (counter == 'Q') counter = 'R';
        	 }
        	 map.put(Integer.toString(i), temp);
        }
        // read dict
        while (dict.hasNext()) {
        	String line = dict.nextLine();
        	set.add(line);
        	if (line.length() >= 5)
        		set2.add(line.substring(0,5));
        }

        namenum na = new namenum();
        na.permutate("", n);

        if (!done) out.println("NONE");

        out.close();
    }
    public void permutate(String prefix, String suffix) {
    	if (prefix.length() == 5) {
    		if (!set2.contains(prefix)) return;
    	}
    	if (suffix.length() == 0) {
    		if (set.contains(prefix)) {
    			out.println(prefix);
    			done = true;
    		}
    	}
    	else {
    		String digit = suffix.substring(0,1);
	    		for (int i = 0; i < 3; i++) {
	    			permutate(new StringBuilder().append(prefix).append(map.get(digit)[i]).toString(), suffix.substring(1));
	    		}
    	}
    }
}
