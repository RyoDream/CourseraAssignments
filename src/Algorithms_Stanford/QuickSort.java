package Algorithms_Stanford;

import java.util.Scanner;

/**
 * Created by shiyanch on 10/17/16.
 */
public class QuickSort {

    int compareCount = 0;
    public void quickSort() {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10000];
        for(int i=0;i<array.length;i++)
            array[i] = scanner.nextInt();
        scanner.close();

        quickSort(array, 0, array.length-1);
        System.out.println(compareCount);
        for(int a: array) {
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public void quickSort(int[] array, int left, int right) {

        if (right <= left)
            return;

        // Use median-of-three as pivot
        // swap(array, left, median3(array, left, right));

        // Use rightmost as pivot
        // swap(array, left, right);

        // Default: use leftmost as povot
        int partition = partition(array, left, right);

        quickSort(array, left, partition - 1);
        quickSort(array, partition + 1, right);
    }

    public int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left+1;
        for(int j=left+1; j<=right; j++) {
            if(array[j] < pivot) {
                swap(array, i, j);
                i = i+1;
            }
        }
        swap(array, left, i-1);
        return i-1;
    }

    public void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public int median3(int[] array, int left ,int right) {
        int mid = (left+right)/2;
        if(array[mid] > array[left] && array[mid] > array[right])
            return array[left]>array[right]?left:right;

        if(array[mid] < array[left] && array[mid] < array[right])
            return array[left] > array[right]?right:left;

        return mid;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort();
    }
}
