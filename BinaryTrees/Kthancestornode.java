package BinaryTrees;
import java.util.*;

public class Kthancestornode {

    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    //  Helper function to find Kth ancestor
    public static int kthAncestor(Node root, int n, int k) {
        // Base case
        if (root == null) return -1;

        // If current node is target node
        if (root.data == n) {
            return 0; // distance from target node
        }

        // Recur for left and right subtrees
        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        // If not found in either subtree
        if (leftDist == -1 && rightDist == -1) return -1;

        // If found in left or right subtree
        int dist = Math.max(leftDist, rightDist) + 1;

        // When distance == k, current node is kth ancestor
        if (dist == k) {
            System.out.println(k + "th ancestor of " + n + " is: " + root.data);
        }

        return dist;
    }

    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7

            Kth ancestor of 5 when k=2 → 1
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int nodeValue = 5;
        int k = 2;
        int result = kthAncestor(root, nodeValue, k);

        if (result == -1) {
            System.out.println("Ancestor not found!");
        }
    }
}
