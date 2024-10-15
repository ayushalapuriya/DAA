

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr1 = {2,4,6,8};
        int[] arr2 = {1,3,5,7};
        int[] ans = new int[arr1.length + arr2.length];

        mergeArrays(arr1, arr2, ans);

        System.out.println("Merged Array: " + Arrays.toString(ans));
    }
    public static void mergeArrays(int[] arr1, int[] arr2, int[] ans) {
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                ans[k] = arr1[i];
                i++;
                k++;
            } else {
                ans[k] = arr2[j];
                j++;
                k++;
            }
        }

        while (i < arr1.length) {
            ans[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            ans[k] = arr2[j];
            j++;
            k++;
        }
    }
}



//timeComplexity = O(n)

