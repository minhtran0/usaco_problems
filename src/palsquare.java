/*
ID: thuba201
LANG: JAVA
TASK: palsquare
*/

import java.io.*;
import java.util.*;

public class palsquare {

	static StringBuilder str;
	static char[] alpha = new char[]{'A','B','C','D','E','F','G','H','I','J'};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("palsquare.in"));
        PrintWriter out = new PrintWriter(new File("palsquare.out"));

        int n = Integer.parseInt(sc.nextLine());

        palsquare p = new palsquare();

        for (int i = 1; i <= 300; i++) {
        	String convert = p.convertBase(i*i, n);
        	if (p.isPalindrome(convert)) {
        		out.println(p.convertBase(i, n)+" "+convert);
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
    	for (int i = 0; i <= len/2; i++) {
    		if (n1.charAt(i) != n1.charAt(len-1-i))	return false;
    	}
    	return true;
    }
}
