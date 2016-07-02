package AlgorithmicToolbox.week5;
import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here
        int[][][] distance = new int[a.length+1][b.length+1][c.length+1];

        for(int i=0;i<a.length+1;i++) {
            for(int j=0;j<b.length+1;j++) {
                for (int k = 0; k < c.length + 1; k++) {
                    if (i == 0 | j == 0 | k == 0)
                        distance[i][j][k] = 0;
                    else if (a[i - 1] == b[j - 1] && b[j - 1] == c[k - 1])
                        distance[i][j][k] = 1 + distance[i - 1][j - 1][k - 1];
                    else
                        distance[i][j][k] = max(distance[i - 1][j][k],
                                distance[i][j - 1][k],
                                distance[i][j][k - 1]);
                }
            }
        }

        return distance[a.length][b.length][c.length];
    }

    private static int max(int a, int b, int c) {
        int max = a;
        if(b > max)
            max = b;
        if(c > max)
            max = c;

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

