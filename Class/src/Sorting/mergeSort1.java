package Sorting;

import java.util.Arrays;

public class mergeSort1 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7, 9, 8};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            mergeArrays(arr, start, mid, end);
        }
    }

    private static void mergeArrays(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, start, temp.length);
    }
}

//time complexity is O(n log n)

