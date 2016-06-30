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
        	int year = 1900+i;
        	if (year%100==0 && year%400==0) {
        		months[1] = 29;
        	}
        	else if (year%100!=0 && year%4==0) {
        		months[1] = 29;
        	}
        	else {
        		months[1] = 28;
        	}
        	// Cycle through months
        	for (int j = 0; j < 12; j++) {
        		int temp = onDay;
        		onDay = (onDay+5)%7;
        		days[onDay]++;
        		onDay = (temp + months[j]%7)%7;
        	}
        }

        for (int i = 0; i < 6; i++) {
        	out.print(days[i] + " ");
        	System.out.print(days[i] + " ");
        }
        out.println(days[6]);
        System.out.println(days[6]);

        out.close();
    }
}
