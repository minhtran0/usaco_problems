/*
ID: thuba201
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.*;

public class dualpal {

	static StringBuilder str;
	static char[] alpha = new char[]{'A','B','C','D','E','F','G','H','I','J'};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("dualpal.in"));
        PrintWriter out = new PrintWriter(new File("dualpal.out"));

        String[] line = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);

        dualpal p = new dualpal();

        int count = 0;
        outloop: for (int i = s+1; i < 50000; i++) {
            int dual = 0;
            for (int b = 2; b <= 10; b++) {
                if (p.isPalindrome(p.convertBase(i,b)))
                    dual++;
            }
            if (dual >= 2) {
                out.println(i); 
                count++;
            }
            if (count >= n) {
                break outloop;
            }
        }

        out.close();
    }
    public String convertBase(int n, int base) {
    	if (base < 10) {
    		str = new StringBuilder();
    		int n1 = n;
    		while(n1 > 0) {
    			str.append(n1%base);
    			n1 /= base;
    		}
    	}
    	else if (base > 10) {
    		str = new StringBuilder();
    		int n1 = n;
    		while (n1 > 0) {
    			int n2 = n1%base;
    			if (n2 < 10)	str.append(n2);
    			else {
    				str.append(alpha[n2-10]);
    			}
    			n1 /= base;
    		}
    	}
    	else	return Integer.toString(n);
    	return str.reverse().toString();
    }
    public boolean isPalindrome(String n) {
    	String n1 = n;
    	int len = n1.length();
    	for (int i = 0; i < len/2; i++) {
    		if (n1.charAt(i) != n1.charAt(len-1-i))	return false;
    	}
    	return true;
    }
}
