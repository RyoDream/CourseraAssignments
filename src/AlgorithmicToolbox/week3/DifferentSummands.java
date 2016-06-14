package AlgorithmicToolbox.week3;

import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int cur = 1;

        while(n > 0) {
            if(n >= cur) {
                summands.add(cur);
                n -= cur;
                cur++;
            } else {
                int prev = summands.get(summands.size()-1);
                summands.remove(summands.size()-1);
                summands.add(prev + n);
                n = 0;
            }
        }

        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

