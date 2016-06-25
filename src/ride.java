/*
ID: thuba201
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.*;

public class ride {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("ride.in"));
        PrintWriter out = new PrintWriter(new File("ride.out"));

        String nameGroup = sc.nextLine();
        String nameComet = sc.nextLine();
	     
	     double cometProd = 1, groupProd = 1;
	     
	     while (nameComet.length() > 0) {
	    	 int subset = (int)(nameComet.charAt(0)) - 64;
	    	 nameComet = nameComet.substring(1);
	    	 cometProd *= subset;
	     }
	     while (nameGroup.length() > 0) {
	    	 int subset = (int)(nameGroup.charAt(0)) - 64;
	    	 nameGroup = nameGroup.substring(1);
	    	 groupProd *= subset;
	     }
	     
	     if (groupProd%47 == cometProd%47) {
	    	 out.println("GO");
	     }
	     else {
	    	 out.println("STAY");
	     }

	     out.close();
	}
}