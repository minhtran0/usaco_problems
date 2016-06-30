/*
ID: thuba201
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.*;

public class barn1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("barn1.in"));
        PrintWriter out = new PrintWriter(new File("barn1.out"));

        String[] input = sc.nextLine().split("\\s+");;
        int M = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);
        int[] occupied = new int[S];

        int[] num = new int[C];

        int start = 0, end = 0;
        for (int i = 0; i < C; i++) {
            int line = Integer.parseInt(sc.nextLine());
            occupied[line - 1] = 1;
            num[i] = line;
        }

        Arrays.sort(num);
        start = num[0] - 1;
        end = num[C-1];

        int groups = 1;
        int total = 0;
        for (int i = start+1; i < end; i++) {
            if (occupied[i] == 1 && occupied[i-1] == 0) 
                groups++;
        }
        total = C;

        while (groups > M) {
            int min = 10000;
            int spacing = 0;
            int index = start;
            for (int i = start; i < end; i++) {
                if (occupied[i] == 0) {
                    spacing++;
                } else if (spacing < min && spacing > 0) {
                    min = spacing;
                    spacing = 0;
                    index = i;
                }
                else
                  spacing = 0;
            }
            total += min;
            for (int j = 0; j < min; j++) {
                occupied[index - j - 1] = 1;
            }
            groups--;
        }

        out.println(total);
        out.close();
    }
}