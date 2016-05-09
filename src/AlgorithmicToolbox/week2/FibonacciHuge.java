package AlgorithmicToolbox.week2;

import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHuge(long n, long m) {
        long res = 0;

        if(n<=1)
            return n;

        long first = 1, second = 1;

        for(int i=2;i<n;i++) {
            long temp = first;
            first += second;
            second = temp;

            first %= m;
            second %= m;
        }

        return first%m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}


