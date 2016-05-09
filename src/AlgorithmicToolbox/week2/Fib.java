package AlgorithmicToolbox.week2;

import java.util.Scanner;

public class Fib {
    private static long calc_fib2(int n) {
        if (n <= 1)
            return n;

        return calc_fib(n - 1) + calc_fib(n - 2);
    }

    private static long calc_fib(int n) {
        if(n<=1)
            return n;

        int[] res = new int[n];
        res[0] = res[1] = 1;

        for(int i=2;i<n;i++) {
            res[i] = res[i-1] + res[i-2];
        }

        return res[n-1];
    }

    private static long calc_fib3(int n) {
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

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
        System.out.println(calc_fib2(n));
        System.out.println(calc_fib3(n));
    }
}
