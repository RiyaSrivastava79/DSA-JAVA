package SegmentTree;

public class QueriesST {
    static int[] tree;

    // Initialize the segment tree array
    public static void init(int n) {
        tree = new int[4 * n];
    }

    // Build the segment tree
    public static void buildST(int[] arr, int i, int start, int end) {
        if (start == end) {
            tree[i] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        buildST(arr, 2 * i + 1, start, mid);
        buildST(arr, 2 * i + 2, mid + 1, end);

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    // Utility function to get the sum in a given range
    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        // Non-overlapping case
        if (qj < si || qi > sj) {
            return 0;
        }

        // Complete overlap
        if (qi <= si && qj >= sj) {
            return tree[i];
        }

        // Partial overlap
        int mid = (si + sj) / 2;
        int left = getSumUtil(2 * i + 1, si, mid, qi, qj);
        int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);

        return left + right;
    }

    // Main getSum function
    public static int getSum(int[] arr, int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;

        init(n);
        buildST(arr, 0, 0, n - 1);

        System.out.print("Segment Tree: ");
        for (int val : tree) {
            System.out.print(val + " ");
        }
        System.out.println();

        // Example queries
        System.out.println("Sum from index 2 to 5 = " + getSum(arr, 2, 5));
    }
}
