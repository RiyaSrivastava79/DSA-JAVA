package Trie;

public class PrefixProb {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq; // frequency of words passing through this node

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 0;
        }
    }

    public static Node root = new Node();

    
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr.children[idx].freq++; // increase frequency for each traversal
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    
    public static void findPrefix(Node root, String ans) {
        if (root == null)
            return;

        if (root.freq == 1) { // unique prefix found
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                findPrefix(root.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    public static void main(String args[]) {
        String arr[] = {"zebra", "dog", "duck", "dove"};

        
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        root.freq = -1;

        
        findPrefix(root, "");
    }
}
