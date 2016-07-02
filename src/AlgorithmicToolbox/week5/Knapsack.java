package AlgorithmicToolbox.week5;

import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int result = 0;
        for (int i = 0; i < w.length; i++) {
            if (result + w[i] <= W) {
                result += w[i];
            }
        }
        return result;
    }

    static int dp_weight(int W, int[] gold) {
        int[][] value = new int[W+1][gold.length+1];

        for(int i=1;i<=gold.length;i++) {
            for(int w=1;w<=W;w++) {
                value[w][i] = value[w][i-1];
                if(gold[i-1] <= w) {
                    int temp = value[w-gold[i-1]][i-1] + gold[i-1];
                    if(temp > value[w][i])
                        value[w][i] = temp;
                }
            }
        }

        return value[W][gold.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(dp_weight(W, w));
    }
}

