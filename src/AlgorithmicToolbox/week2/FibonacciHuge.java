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

            if(second > m)
                second %= m;
            if(first > m)
                first %= m;
        }

        return first;
    }

    private static long findLoop(long n, long m) {
        ArrayList<Long> array = new ArrayList<>();

        int flag = -1;
        array.add(0l);
        array.add(1l);
        array.add(1l);
        for(int i=3;i<=n;i++) {
            long temp = (array.get(i-2) + array.get(i-1))%m;
            array.add(temp);
            if(temp == 1 && array.get(i-1) == 0) {
                flag = i - 1;
                break;
            }
        }

        if(flag != -1) {
            int index = (int) (n % flag);
            return array.get(index);
        }
        else
            return array.get((int)n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextInt();
        System.out.println(findLoop(n, m));
    }
}


