package AlgorithmicToolbox.week2;

import java.util.*;

public class LCM {
    private static long lcm(int a, int b) {
        return (long)a*b/gcd(a,b);
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

        System.out.println(lcm(a, b));
    }
}
