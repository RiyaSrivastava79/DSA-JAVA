package BinaryTrees;
import java.util.*;

public class lowestcommonAncestor {

    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Helper function to find path from root to given node n
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root); // add current node

        if (root.data == n) {
            return true;
        }

        // search in left and right subtrees
        if (getPath(root.left, n, path) || getPath(root.right, n, path)) {
            return true;
        }

        // not found in either side → backtrack
        path.remove(path.size() - 1);
        return false;
    }

    // Main LCA function
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if (!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
            return null; // if either node not found
        }

        int i = 0;
        // find last common node in both paths
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        return path1.get(i - 1); // previous common node
    }

    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7

            LCA(4,5) = 2
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // int n1 = 4, n2 = 5;
        int n1 = 4, n2 = 7;
        Node ans = lca(root, n1, n2);
        if (ans != null)
            System.out.println("LCA of " + n1 + " and " + n2 + " is: " + ans.data);
        else
            System.out.println("LCA does not exist");
    }
}
