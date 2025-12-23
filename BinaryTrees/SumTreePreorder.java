package BinaryTrees;

public class SumTreePreorder {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    //  Transform to sum tree using preorder traversal
    public static int transformToSumTree(Node root) {
        if (root == null) return 0;

        int oldVal = root.data;

        // visit root first (preorder step)
        // temporarily keep data = 0 so that subtree sums are computed correctly
        root.data = 0;

        // recursive calls (still preorder style)
        int leftSum = transformToSumTree(root.left);
        int rightSum = transformToSumTree(root.right);

        // update node after processing children
        root.data = leftSum + rightSum;

        // return total sum (including old value) to parent
        return root.data + oldVal;
    }

    //  Print preorder traversal
    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7

        After transforming to Sum Tree:
                 27
               /    \
              9      13
             / \    / \
            0   0  0   0
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Preorder traversal before transformation:");
        preorder(root);

        transformToSumTree(root);

        System.out.println("\n\nPreorder traversal after transformation:");
        preorder(root);
    }
}
