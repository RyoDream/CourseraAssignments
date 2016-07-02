package AlgorithmicToolbox.week5;

import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {
        int[][] distance = new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++)
            distance[i][0] = i;

        for(int j=0;j<t.length()+1;j++)
            distance[0][j] = j;

        for(int j=1;j<t.length()+1;j++) {
            for(int i=1;i<s.length()+1;i++) {
                int insertion = distance[i][j-1]+1;
                int deletion = distance[i-1][j]+1;
                int match = distance[i-1][j-1];
                int mismatch = distance[i-1][j-1]+1;

                if(s.charAt(i-1) == t.charAt(j-1))
                    distance[i][j] = min(insertion, deletion, match);
                else
                    distance[i][j] = min(insertion, deletion, mismatch);
            }
        }

        //write your code here
        return distance[s.length()][t.length()];
    }

    private static int min(int a, int b, int c){
        int min = a;
        if(b < min)
            min = b;
        if(c < min)
            min = c;

        return min;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }
}
