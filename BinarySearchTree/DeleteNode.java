package BinarySearchTree;
import java.util.*;

public class DeleteNode {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert a node into BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Inorder Traversal (Left, Root, Right)
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Find inorder successor (minimum node in right subtree)
    public static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Delete a node from BST using 3 cases
    public static Node delete(Node root, int val) {
        if (root == null) return null;

        if (val < root.data) {
            root.left = delete(root.left, val);
        } 
        else if (val > root.data) {
            root.right = delete(root.right, val);
        } 
        else {
            //  Node to be deleted found
            System.out.println("\nDeleting node: " + root.data);

            // Case 1: No child (leaf node)
            if (root.left == null && root.right == null) {
                System.out.println("→ Case 1: No child");
                return null;
            }

            // Case 2: One child
            else if (root.left == null) {
                System.out.println("→ Case 2: One child (right)");
                return root.right;
            } 
            else if (root.right == null) {
                System.out.println("→ Case 2: One child (left)");
                return root.left;
            }

            // Case 3: Two children
            else {
                System.out.println("→ Case 3: Two children");
                Node successor = findMin(root.right);
                System.out.println("   Inorder Successor: " + successor.data);
                root.data = successor.data; // replace value
                root.right = delete(root.right, successor.data); // delete successor
            }
        }

        return root;
    }
    public static void printInRange(Node root, int k1, int k2) {
    if (root == null) {
        return;
    }

    if (root.data >= k1 && root.data <= k2) {
        printInRange(root.left, k1, k2);
        System.out.print(root.data + " ");
        printInRange(root.right, k1, k2);
    } 
    else if (root.data < k1) {
        printInRange(root.right, k1, k2);
    } 
    else {
        printInRange(root.left, k1, k2);
    }
}

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        // Insert nodes
        for (int val : values) {
            root = insert(root, val);
        }

        // System.out.println("Inorder traversal before deletion:");
        // inorder(root);

        // 🔹 Try deleting a few nodes
        // root = delete(root, 1);   // Case 1: No child
        // root = delete(root, 5);   // Case 3: Two children
        // root = delete(root, 11);  // Case 2: One child

        // System.out.println("\n\nInorder traversal after deletions:");
        // inorder(root);
        // System.out.println();

        printInRange(root, 5, 12);
    }
}
