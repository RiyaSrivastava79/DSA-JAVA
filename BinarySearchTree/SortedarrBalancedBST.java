package BinarySearchTree;
import java.util.*;

public class SortedarrBalancedBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Function to create Balanced BST from Sorted Array
    public static Node createBST(int arr[], int st, int end) {
        if (st > end) {  
            return null;
        }

        int mid = (st + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = createBST(arr, st, mid - 1);
        root.right = createBST(arr, mid + 1, end);

        return root;
    }

    // Preorder traversal to verify structure
    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //  main method
    public static void main(String args[]) {
        int arr[] = {3, 5, 6, 8, 10, 11, 12};

        Node root = createBST(arr, 0, arr.length - 1);

        System.out.println("Preorder traversal of Balanced BST:");
        preorder(root);
    }
}