package BinarySearchTree;
import java.util.*;
public class MirrorBST {

    // Node class
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Function to create mirror of the tree
    public static Node createMirror(Node root) {
        if (root == null) {
            return null;
        }

        // Recursively mirror left and right subtrees
        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        // Swap left and right children
        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    // Preorder traversal
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Main method
    public static void main(String args[]) {

        /*
            Original BST:
                   8
                 /   \
                5     10
               / \      \
              3   6      11
        */

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        // Create mirror
        root = createMirror(root);

        /*
            Mirror BST:
                   8
                 /   \
               10     5
              /     /   \
             11    6     3
        */

        System.out.println("Preorder of Mirror BST:");
        preorder(root);
    }
}