package BinarySearchTree;

import java.util.*;

public class MergetwoBsts {

    //Node class for Binary Search Tree
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Step 1: Get Inorder traversal (sorted order for BST)
    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) return;

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    // Step 2: Merge two sorted ArrayLists (from inorder of both BSTs)
    public static ArrayList<Integer> mergeSortedArrays(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> finalArr = new ArrayList<>();
        int i = 0, j = 0;

        // Merge while both lists have elements
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        // Add remaining elements of arr1
        while (i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }

        // Add remaining elements of arr2
        while (j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        return finalArr;
    }

    // Step 3: Create Balanced BST from a sorted ArrayList
    public static Node createBST(ArrayList<Integer> arr, int st, int end) {
        if (st > end) return null;

        int mid = (st + end) / 2;
        Node root = new Node(arr.get(mid));

        root.left = createBST(arr, st, mid - 1);
        root.right = createBST(arr, mid + 1, end);

        return root;
    }

    //Step 4: Merge two BSTs into one balanced BST
    public static Node mergeBSTs(Node root1, Node root2) {
        // Step 1: Get inorder of both BSTs
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // Step 2: Merge both sorted inorder lists
        ArrayList<Integer> finalArr = mergeSortedArrays(arr1, arr2);

        // Step 3: Convert merged sorted list → balanced BST
        return createBST(finalArr, 0, finalArr.size() - 1);
    }

    //Step 5: Preorder traversal to verify final BST structure
    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Main function
    public static void main(String args[]) {

        /*
            BST 1:
                   2
                 /   \
                1     4
        */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        /*
            BST 2:
                   9
                 /   \
                3     12
        */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        // Merge both BSTs
        Node root = mergeBSTs(root1, root2);

        // Print preorder of final merged BST
        System.out.println("Preorder traversal of merged balanced BST:");
        preorder(root);
    }
}