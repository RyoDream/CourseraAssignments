package AlgorithmicToolbox.week2;

import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigit(int n) {
        if(n<=1)
            return n;

        int first = 1, second = 1;

        for(int i=2;i<n;i++) {
            int temp = first;
            first += second;
            second = temp;

            first %= 10;
            second %= 10;
        }

        return first;
    }

    private static long calc_fib(int n) {
        if(n<=1)
            return n;

        int first = 1, second = 1;

        for(int i=2;i<n;i++) {
            int temp = first;
            first += second;
            second = temp;
        }

        return first;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
        System.out.println(calc_fib(n));
    }
}

