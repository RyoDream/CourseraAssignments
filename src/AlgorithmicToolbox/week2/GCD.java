package AlgorithmicToolbox.week2;

import java.util.*;

public class GCD {
    private static int gcd2(int a, int b) {
        int current_gcd = 1;
        for(int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }

        return current_gcd;
    }

    private static int gcd(int a, int b) {
        while(a!=0 && b!=0) {
            if(a > b)
                a %= b;
            else
                b %= a;
        }

        return (a==0)?b:a;

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd(a, b));
        System.out.println(gcd2(a, b));
    }
}
