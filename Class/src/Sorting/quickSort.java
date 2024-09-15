package Sorting;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 4, 6};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int[] arr, int si, int ei) {
        if (si < ei) {
            int pi = partition(arr, si, ei);
            quicksort(arr, si, pi - 1);
            quicksort(arr, pi + 1, ei);
        }
    }

    private static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int pi = si;

        for (int i = si; i < ei; i++) {
            if (arr[i] <= pivot) {

                int temp = arr[i];
                arr[i] = arr[pi];
                arr[pi] = temp;
                pi++;
            }
        }


        int temp = arr[ei];
        arr[ei] = arr[pi];
        arr[pi] = temp;

        return pi;
    }
}
