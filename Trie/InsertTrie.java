package Trie;

public class InsertTrie {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false; // end of word flag

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    // Insert function
    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a'; // fixed subtraction
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx]; // move to child
        }
        curr.eow = true; // mark end of word
    }

    // Main function
    public static void main(String args[]) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println("All words inserted successfully!");
    }
}