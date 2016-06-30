/*
ID: thuba201
LANG: JAVA
TASK: transform
*/

import java.io.*;
import java.util.*;

public class transform {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("transform.in"));
        PrintWriter out = new PrintWriter(new File("transform.out"));

        int n = Integer.parseInt(sc.nextLine());
        
        // angle is 360 - angle bc clockwise

        String[] begin = new String[n];
        String[] end = new String[n];

        for (int i = 0; i < n; i++) 
        	begin[i] = sc.nextLine();
        for (int i = 0; i < n; i++) 
        	end[i] = sc.nextLine();

        boolean done1 = true, done2 = true, done3 = true, done4 = true;
        transform t = new transform();

        int[] c = new int[2];
        int[] rot = new int[2];
        int[] r = new int[2];

        loop1: for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) {
        	c = t.coor(i, j, n);

        	if (done1) {
        		rot = t.rotate(c[0], c[1], 360-90);
        		r = t.reverseCoor(rot[0], rot[1], n);
        		if (begin[i].charAt(j) != end[r[0]].charAt(r[1])) {
        			done1 = false;
        		}
        	}

        	if (done2) {
        		rot = t.rotate(c[0], c[1], 360-180);
        		r = t.reverseCoor(rot[0], rot[1], n);
        		if (begin[i].charAt(j) != end[r[0]].charAt(r[1])) {
        			done2 = false;
        		}
        	}

        	if (done3) {
        		rot = t.rotate(c[0], c[1], 360-270);
        		r = t.reverseCoor(rot[0], rot[1], n);
        		if (begin[i].charAt(j) != end[r[0]].charAt(r[1])) {
        			done3 = false;
        		}
        	}
        	if (done4) {
        		if (begin[i].charAt(j) != end[i].charAt(j)) {
        			done4 = false;
        		}
        	}
        	if (!done1 && !done2 && !done3 && !done4)	
        		break loop1;
        }
        if (done1)	{out.println("1"); out.close(); System.exit(0);}
        if (done2)	{out.println("2"); out.close(); System.exit(0);}
        if (done3)	{out.println("3"); out.close(); System.exit(0);}

        //int[][] rCoor = new int[n][n];

        done1 = true;

        // reflection
        loop2: for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) {
        	c = t.coor(i, j, n);
        	r = t.reverseCoor(-c[0], c[1], n);
        	if (begin[i].charAt(j) != end[r[0]].charAt(r[1])) {
        		done1 = false; break loop2;
        	}
        }
        if (done1)	{out.println("4"); out.close(); System.exit(0);}
        
        done1 = done2 = done3 = true;

        loop3: for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) {
        	c = t.coor(i, j, n);
        	c[0] = -c[0];

        	if (done1) {
        		rot = t.rotate(c[0], c[1], 360-90);
        		r = t.reverseCoor(rot[0], rot[1], n);
        		if (begin[i].charAt(j) != end[r[0]].charAt(r[1])) {
        			done1 = false;
        		}
        	}

        	if (done2) {
        		rot = t.rotate(c[0], c[1], 360-180);
        		r = t.reverseCoor(rot[0], rot[1], n);
        		if (begin[i].charAt(j) != end[r[0]].charAt(r[1])) {
        			done2 = false;
        		}
        	}

        	if (done3) {
        		rot = t.rotate(c[0], c[1], 360-270);
        		r = t.reverseCoor(rot[0], rot[1], n);
        		if (begin[i].charAt(j) != end[r[0]].charAt(r[1])) {
        			done3 = false;
        		}
        	}
        	if (!done1 && !done2 && !done3)	
        		break loop3;
        }
        if (done1||done2||done3)	{out.println("5"); out.close(); System.exit(0);}
        if (done4)	{out.println("6"); out.close(); System.exit(0);}
        out.println("7"); out.close(); System.exit(0);

        out.close();
    }
    public int[] rotate(int x, int y, int angle) {
    	// angle in degrees
    	int x1 = (int)(Math.cos(Math.toRadians(angle))*x) - (int)(Math.sin(Math.toRadians(angle))*y);
    	int y1 = (int)(Math.sin(Math.toRadians(angle))*x) + (int)(Math.cos(Math.toRadians(angle))*y);
    	return new int[]{x1, y1};
    }
    public int[] reverseCoor(int x, int y, int n) {
    	if (n%2 == 1) {
    		return new int[]{-y+n/2, x+n/2};
    	}
    	else {
    		if (x < 0 && y > 0)
    			return new int[]{-y+n/2, x+n/2};
    		else if (x > 0 && y > 0)
    			return new int[]{-y+n/2, x-1+n/2};
    		else if (x < 0 && y < 0)
    			return new int[]{-(y+1)+n/2, x+n/2};
    		else
    			return new int[]{-(y+1)+n/2, x-1+n/2};
    	}
    }
    public int[] coor(int x, int y, int n) {
    	if (n%2 == 1) {
    		return new int[]{y-n/2, -(x-n/2)};
    	}
    	else {
    		if (x < n/2 && y < n/2)
    			return new int[]{y-n/2, -(x-n/2)};
    		else if (x < n/2 && y >= n/2)
    			return new int[]{y-n/2+1, -(x-n/2)};
    		else if (x >= n/2 && y < n/2)
    			return new int[]{y-n/2, -(x-n/2)-1};
    		else
    			return new int[]{y-n/2+1, -(x-n/2)-1};
    	}
    }
}
