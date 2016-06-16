package AlgorithmicToolbox.week4;

import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        int majority = 0;
        int count = 0;

        for(int i=0;i<a.length;i++) {
            if(count == 0) {
                majority = a[i];
                count = 1;
            }
            else {
                if(a[i] == majority)
                    count++;
                else
                    count--;
            }
        }

        if(getFrequency(a, majority) > a.length/2)
            return majority;
        else return -1;
    }

    private static int getMajorityElement2(int[] a, int left, int right) {

        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here

        int mid = (left+right)/2;

        int leftMajority = getMajorityElement2(a,left, mid);
        int rightMajority = getMajorityElement2(a, mid+1, right);

        if(leftMajority == rightMajority)
            return leftMajority;

        int leftCount = getFrequency(a, leftMajority);
        int rightCount = getFrequency(a, rightMajority);

        if(leftCount > mid+1)
            return leftMajority;
        else if (rightCount > mid+1)
            return rightMajority;
        else
            return -1;
    }

    private static int getFrequency(int[] a, int majority) {
        int count = 0;
        for(int num:a) {
            if(num == majority)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

