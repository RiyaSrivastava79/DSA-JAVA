package BinarySearchTree;
import java.util.*;

public class Pathroottoleaf {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Insert node in BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Inorder traversal (for checking tree)
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Print all root-to-leaf paths
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        // If it's a leaf node
        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            // Recursive calls
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }

    // Helper to print a path
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i != path.size() - 1) System.out.print(" -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};

        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println("\n\nRoot to Leaf Paths:");
        printRoot2Leaf(root, new ArrayList<>());
    }
}