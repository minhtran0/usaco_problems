/*
ID: thuba201
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;

public class beads {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("beads.in"));
        PrintWriter out = new PrintWriter(new File("beads.out"));

        int n = Integer.parseInt(sc.nextLine());
        String bead = sc.nextLine();
        int start = bead.length();
        int end = 2*bead.length();
        bead = bead + bead + bead;
        int max = 0;

        outloop: for (int i = start; i < end; i++) {
        	int a = 1, b = 1;
        	String first = bead.substring(i-1,i);
     		for (int j = 2; j <= start; j++) {
     			if (first.equals("w")) {
     				if (bead.substring(i-j,i-j+1).equals("w")) {
     					a++;
     					continue;
     				}
     				else {
     					a++;
     					first = bead.substring(i-j,i-j+1);
     					continue;
     				}
     			}
     			else if (bead.substring(i-j,i-j+1).equals("w") || 
     				bead.substring(i-j,i-j+1).equals(first)) {
     				a++;
     			}
     			else
     				break;
     		}
     		first = bead.substring(i,i+1);
     		for (int j = 1; j <= start; j++) {
     			if (first.equals("w")) {
     				if (bead.substring(i+j,i+j+1).equals("w")) {
     					b++;
     					continue;
     				}
     				else {
     					b++;
     					first = bead.substring(i+j,i+j+1);
     					continue;
     				}
     			}
     			else if (bead.substring(i+j,i+j+1).equals("w") || 
     				bead.substring(i+j,i+j+1).equals(first)) {
     				b++;
     			}
     			else
     				break;
     		}
     		if (a+b > max) {
     			if (a+b >= start) {
     				max = start;
     				break outloop;
     			}
     			else
     				max = a+b;
     		}

        }

        out.println(max);

        out.close();
    }
}