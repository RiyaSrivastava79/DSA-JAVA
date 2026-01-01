package BinaryTrees;

public class Heightoftree {
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

    // Method to calculate the height of the tree
    public static int height(Node root) {
        if (root == null) {
            return 0;  // height of empty tree is 0
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

     //Method to count total number of nodes
    public static int count(Node root) {
        if (root == null) {
            return 0; // no node
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1; // count current node
    }

    //Method to find sum of all nodes
    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    }

    //Simple (O(n²)) Diameter Method
    public static int diameter2(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDiam = diameter2(root.left);
        int leftHt = height(root.left);
        int rightDiam = diameter2(root.right);
        int rightHt = height(root.right);

        int selfDiam = leftHt + rightHt + 1;

        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }

     //Optimized (O(n)) 
    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    // Function to calculate diameter (Optimized O(n))
    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);  // base case: diameter=0, height=0
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(
    Math.max(leftInfo.diam, rightInfo.diam),
    leftInfo.ht + rightInfo.ht + 1
);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }



    public static void main(String[] args) {
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

        // Calculate and print height
        // System.out.println("Height of the tree: " + height(root));
        // System.out.println("Total number of nodes: " + count(root));
        // System.out.println(sum(root));

        // System.out.println(diameter2(root));
        System.out.println(diameter(root).diam);
    }
}
