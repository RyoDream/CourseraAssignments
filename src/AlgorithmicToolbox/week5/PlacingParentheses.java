package AlgorithmicToolbox.week5;

import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        //write your code here
        long[] digits = getDigits(exp);
        char[] operators = getOperators(exp);
        int n = digits.length;

        long[][] minValue = new long[n+1][n+1];
        long[][] maxValue = new long[n+1][n+1];

        for(int i=1;i<n+1;i++) {
            minValue[i][i] = digits[i-1];
            maxValue[i][i] = digits[i-1];
        }

        for(int s=1;s<n;s++) {
            for(int i=1;i<n-s+1;i++) {
                int j = i+s;
                long[] minAndMax = MinAndMax(i,j,operators,maxValue,minValue);
                minValue[i][j] = minAndMax[0];
                maxValue[i][j] = minAndMax[1];
            }
        }

        return maxValue[1][n];
    }

    private static long[] MinAndMax(int i, int j, char[] operators, long[][] maxValue, long[][] minValue) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for(int k=i;k<j;k++) {
            long a = eval(maxValue[i][k], maxValue[k+1][j], operators[k-1]);
            long b = eval(maxValue[i][k], minValue[k+1][j], operators[k-1]);
            long c = eval(minValue[i][k], maxValue[k+1][j], operators[k-1]);
            long d = eval(minValue[i][k], minValue[k+1][j], operators[k-1]);

            min = findMin(min,a,b,c,d);
            max = findMax(max,a,b,c,d);
        }

        return new long[] {min, max};
    }

    private static long findMin(long a, long b, long c, long d, long e) {
        long min = a;
        if(b < min)
            min = b;
        if(c < min)
            min = c;
        if(d < min)
            min = d;
        if(e < min)
            min = e;

        return min;
    }

    private static long findMax(long a, long b, long c, long d, long e) {
        long max = a;
        if(b > max)
            max = b;
        if(c > max)
            max = c;
        if(d > max)
            max = d;
        if(e > max)
            max = e;

        return max;
    }

    private static char[] getOperators(String exp) {
        char[] operators = new char[(exp.length()-1)/2];
        for(int i=0;i*2+1<exp.length();i++) {
            operators[i] = exp.charAt(i*2+1);
        }

        return operators;
    }

    private static long[] getDigits(String exp) {
        long[] digits = new long[(exp.length()-1)/2+1];
        for(int i=0;i*2<exp.length();i++)
            digits[i] = exp.charAt(i*2)-'0';

        return digits;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

