package Trie;
import java.util.*;

public class UniqueSubstring {

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false; // end of word
    }

    public static Node root = new Node();

    // Insert a word into the Trie
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // Count total nodes in Trie
    public static int countNodes(Node root) {
        if (root == null) return 0;

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1; // +1 for current node
    }

    public static void main(String[] args) {
        String str = "ababa"; // expected answer = 10

        // Insert all suffixes into Trie
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        // Total unique substrings = total nodes - 1 (exclude root)
        int result = countNodes(root) - 1;
        System.out.println("Unique substrings: " + result);
    }
}
