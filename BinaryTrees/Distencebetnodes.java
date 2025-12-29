package BinaryTrees;

public class Distencebetnodes {

    // Node class
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Function to find LCA of two nodes
    public static Node lca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = lca(root.left, n1, n2);
        Node rightLCA = lca(root.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return root; // current node is LCA
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Helper function to find distance from root to a given node
    public static int findDistance(Node root, int n) {
        if (root == null) return -1;
        if (root.data == n) return 0;

        int leftDist = findDistance(root.left, n);
        int rightDist = findDistance(root.right, n);

        if (leftDist == -1 && rightDist == -1) return -1;
        else if (leftDist == -1) return rightDist + 1;
        else return leftDist + 1;
    }

    //Function to find minimum distance between two nodes
    public static int minDistance(Node root, int n1, int n2) {
        Node lcaNode = lca(root, n1, n2);

        int d1 = findDistance(lcaNode, n1);
        int d2 = findDistance(lcaNode, n2);

        return d1 + d2;
    }

    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7

            Distance(4,5) = 2
            Distance(4,6) = 4
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Min Distance between 4 and 5: " + minDistance(root, 4, 5));
        System.out.println("Min Distance between 4 and 6: " + minDistance(root, 4, 6));
    }
}

