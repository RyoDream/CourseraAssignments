package AlgorithmicToolbox.week3;

import java.util.Scanner;

public class Change {
    private static int getChange(int n) {
        int count = 0;

        while(n > 0) {
            if(n >= 10)
                n -= 10;
            else if(n >= 5)
                n -= 5;
            else
                n -= 1;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getChange(n));

    }
}

