package SegmentTree;
public class MaxMinSTcreation{

    static int tree[];

    // Initialize segment tree
    public static void init(int n) {
        tree = new int[4 * n]; // 4*n is safe for segment tree size
    }

    // Build segment tree
    public static void buildTree(int i, int si, int sj, int arr[]) {
        if (si == sj) { // leaf node
            tree[i] = arr[si];
            return;
        }

        int mid = (si + sj) / 2;
        buildTree(2 * i, si, mid, arr);       // left child
        buildTree(2 * i + 1, mid + 1, sj, arr); // right child

        tree[i] = Math.max(tree[2 * i], tree[2 * i + 1]); // store max
    }

    // Optional: query maximum in a range [l, r]
    public static int query(int i, int si, int sj, int l, int r) {
        if (r < si || l > sj) return Integer.MIN_VALUE; // no overlap
        if (l <= si && sj <= r) return tree[i];         // complete overlap

        int mid = (si + sj) / 2;
        int left = query(2 * i, si, mid, l, r);
        int right = query(2 * i + 1, mid + 1, sj, l, r);

        return Math.max(left, right);
    }

    public static void main(String args[]) {
        int arr[] = {6, 8, 1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;

        init(n);
        buildTree(1, 0, n - 1, arr);

        // Print the segment tree array
        for (int i = 1; i < 2 * n; i++) { // usually first few indices store tree
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        // Example query: max in range [1, 5]
        System.out.println("Max in range [1,5]: " + query(1, 0, n - 1, 1, 5));
    }
}