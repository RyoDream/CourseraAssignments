package AlgorithmicToolbox.week5;

import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    private static List<Integer> dp_sequence(int n) {
        List<Integer> sequence = new ArrayList<>();
        int[] counts = new int[n+1];

        for(int i=2;i<=n;i++) {
            int minOperation = Integer.MAX_VALUE;

            if(i%3 == 0 && minOperation > counts[i/3]+1) {
                minOperation = counts[i/3]+1;
                counts[i] = minOperation;
            }

            if(i%2 == 0 && minOperation > counts[i/2]+1) {
                minOperation = counts[i/2]+1;
                counts[i] = minOperation;
            }

            if(minOperation > counts[i-1]+1) {
                counts[i] = counts[i-1]+1;
            }

        }

        while(n>=1) {
            sequence.add(n);
            int minFlag = Integer.MAX_VALUE;
            int nextN = 0;
            if(n%3 == 0 && minFlag > counts[n/3]) {
                minFlag = counts[n/3];
                nextN = n/3;
            }
            if(n%2 == 0 && minFlag > counts[n/2]) {
                minFlag = counts[n/2];
                nextN = n/2;
            }
            if(minFlag > counts[n-1])
                nextN = n-1;

            n = nextN;
        }

        Collections.reverse(sequence);
        return sequence;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = dp_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}


