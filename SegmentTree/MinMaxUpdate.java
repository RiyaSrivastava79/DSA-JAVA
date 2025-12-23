package SegmentTree;

public class MinMaxUpdate {
    static int tree[];

    // Initialize the tree
    public static void init(int n) {
        tree = new int[4 * n];
    }

    // Build segment tree
    public static void buildTree(int i, int si, int sj, int arr[]) {
        if (si == sj) {
            tree[i] = arr[si];
            return;
        }

        int mid = (si + sj) / 2;
        buildTree(2 * i + 1, si, mid, arr);      // left child
        buildTree(2 * i + 2, mid + 1, sj, arr);  // right child

        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    // Get max in a range [qi, qj]
    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        // No overlap
        if (qj < si || qi > sj) {
            return Integer.MIN_VALUE;
        }

        // Complete overlap
        if (qi <= si && sj <= qj) {
            return tree[i];
        }

        // Partial overlap
        int mid = (si + sj) / 2;
        int leftAns = getMaxUtil(2 * i + 1, si, mid, qi, qj);
        int rightAns = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);

        return Math.max(leftAns, rightAns);
    }

    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n - 1, qi, qj);
    }

    // Update value at index idx to newVal
    public static void updateUtil(int i, int si, int sj, int idx, int newVal) {
        if (idx < si || idx > sj) {
            return; // no overlap
        }

        if (si == sj) {
            tree[i] = newVal;
            return;
        }

        int mid = (si + sj) / 2;
        updateUtil(2 * i + 1, si, mid, idx, newVal);
        updateUtil(2 * i + 2, mid + 1, sj, idx, newVal);

        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static void update(int arr[], int idx, int newVal) {
        arr[idx] = newVal;
        updateUtil(0, 0, arr.length - 1, idx, newVal);
    }

    public static void main(String args[]) {
        int arr[] = {6, 8, 1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;

        init(n);
        buildTree(0, 0, n - 1, arr);

        System.out.println(getMax(arr, 2, 5)); // 17
        update(arr, 2, 20);
        System.out.println(getMax(arr, 2, 5)); // 20
    }
}