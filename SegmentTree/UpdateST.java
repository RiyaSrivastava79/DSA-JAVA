package SegmentTree;

public class UpdateST {

    static int[] tree;

    // Initialize segment tree array
    public static void init(int n) {
        tree = new int[4 * n]; // maximum size of segment tree
    }

    // Build segment tree
    public static int buildST(int[] arr, int i, int si, int sj) {
        if (si == sj) { // leaf node
            tree[i] = arr[si];
            return tree[i];
        }
        int mid = (si + sj) / 2;
        tree[i] = buildST(arr, 2 * i + 1, si, mid) + buildST(arr, 2 * i + 2, mid + 1, sj);
        return tree[i];
    }

    // Range sum query
    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        if (qi > sj || qj < si) { // no overlap
            return 0;
        }
        if (qi <= si && sj <= qj) { // complete overlap
            return tree[i];
        }
        // partial overlap
        int mid = (si + sj) / 2;
        return getSumUtil(2 * i + 1, si, mid, qi, qj) +
               getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);
    }

    public static int getSum(int[] arr, int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    // Point update
    public static void updateUtil(int i, int si, int sj, int idx, int diff) {
        if (idx < si || idx > sj) { // out of range
            return;
        }
        tree[i] += diff;
        if (si != sj) { // not a leaf node
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, idx, diff);
            updateUtil(2 * i + 2, mid + 1, sj, idx, diff);
        }
    }

    public static void update(int[] arr, int idx, int newVal) {
        int diff = newVal - arr[idx];
        arr[idx] = newVal;
        updateUtil(0, 0, arr.length - 1, idx, diff);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;

        init(n);
        buildST(arr, 0, 0, n - 1);

        System.out.println(getSum(arr, 2, 5)); // sum from index 2 to 5: 3+4+5+6 = 18

        update(arr, 2, 2); // change arr[2] from 3 to 2

        System.out.println(getSum(arr, 2, 5)); // sum now: 2+4+5+6 = 17
    }
}