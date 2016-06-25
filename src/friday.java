/*
ID: thuba201
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.*;

public class friday {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("friday.in"));
        PrintWriter out = new PrintWriter(new File("friday.out"));
        
        int years = Integer.parseInt(sc.nextLine());
        int start = 1900;
        int[] months = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int[] days = new int[7];

        int onDay = 2;

        for (int i = 0; i < years; i++) {
        	// Check if leap year
        	if () {

        	}
        	// Cycle through months
        	for (int j = 0; j < 12; j++) {
        		onDay += 6;
        		days[onDay]++;
        		onDay = onDay - 6 + months[j]%7;
        	}
        }
    }
}
