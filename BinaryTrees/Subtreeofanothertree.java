package BinaryTrees;

public class Subtreeofanothertree {

    // Node class
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to check if two trees are identical
    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }
        if (node == null || subRoot == null) {
            return false;
        }

        if (node.data != subRoot.data) {
            return false;
        }

        return isIdentical(node.left, subRoot.left) &&
               isIdentical(node.right, subRoot.right);
    }

    // Function to check if subRoot is a subtree of root
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        // Otherwise, check in left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        // Main tree
        /*
                1
               / \
              2   3
             / \ / \
            4  5 6  7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Subtree
        /*
                2
               / \
              4   5
        */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        // Output only true or false
        System.out.println(isSubtree(root, subRoot));
    }
}
