package Heap;
import java.util.*;
public class HeapSort {

    // Function to heapify a subtree rooted at index i
    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        // Compare with left child
        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        // Compare with right child
        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        // If max is not root
        if (maxIdx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            // recursively heapify affected subtree
            heapify(arr, maxIdx, size);
        }
    }

    // Heap sort function
    public static void heapSort(int arr[]) {
        int n = arr.length;

        // Step 1: Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // Step 2: Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (largest) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, 0, i);
        }
    }

    // Main method
    public static void main(String args[]) {
        int arr[] = {1, 2, 4, 5, 3};

        heapSort(arr);

        // Print sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}