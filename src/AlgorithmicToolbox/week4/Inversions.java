package AlgorithmicToolbox.week4;

import java.util.*;
import java.util.stream.StreamSupport;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);

        int index1 = left;
        int index2 = ave;
        int count = left;

        boolean cal = false;

        while(index1 < ave && index2 < right) {
            if(a[index1] <= a[index2]) {
                b[count++] = a[index1++];
            }
            else {
                b[count++] = a[index2++];
                numberOfInversions += (ave-index1);
            }
        }

        while(index1 < ave) {
            b[count++] = a[index1++];
        }

        while(index2 < right) {
            b[count++] = a[index2++];
        }

        for(int i=left;i<right;i++)
            a[i] = b[i];

        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}

