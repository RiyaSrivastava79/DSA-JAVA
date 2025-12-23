package SegmentTree;

public class MinMaxQueries {

    static int[] tree;

    // Initialize segment tree
    public static void init(int n) {
        tree = new int[4 * n]; // safe size
    }

    // Build segment tree for max queries
    public static void buildTree(int i, int si, int sj, int arr[]) {
        if (si == sj) { // leaf node
            tree[i] = arr[si];
            return;
        }

        int mid = (si + sj) / 2;
        buildTree(2 * i + 1, si, mid, arr);      // left child
        buildTree(2 * i + 2, mid + 1, sj, arr);  // right child

        // parent stores max
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    // Query for max in range [qi, qj]
    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n - 1, qi, qj); // start from index 0 (root)
    }

    private static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if (si > qj || sj < qi) { // no overlap
            return Integer.MIN_VALUE;
        } else if (si >= qi && sj <= qj) { // complete overlap
            return tree[i];
        } else { // partial overlap
            int mid = (si + sj) / 2;
            int leftAns = getMaxUtil(2 * i + 1, si, mid, qi, qj);
            int rightAns = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return Math.max(leftAns, rightAns);
        }
    }

    public static void main(String args[]) {
        int arr[] = {6, 8, 1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;

        init(n);
        buildTree(0, 0, n - 1, arr);

        int max = getMax(arr, 2, 5); // correct method call syntax
        System.out.println("Maximum in range [2, 5]: " + max);
    }
}
