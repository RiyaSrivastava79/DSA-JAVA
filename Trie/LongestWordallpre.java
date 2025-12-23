package Trie;

public class LongestWordallpre {

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false; // end of word
    }

    static Node root = new Node();
    static String ans = "";

    // Insert word into trie
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

    // Recursive function to find longest word
    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) return;

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);

                // Update answer if this word is longer (or lexicographically smaller)
                if (temp.length() > ans.length() ||
                    (temp.length() == ans.length() && temp.toString().compareTo(ans) < 0)) {
                    ans = temp.toString();
                }

                longestWord(root.children[i], temp);

                // backtrack
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String args[]) {
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        longestWord(root, new StringBuilder());
        System.out.println("Longest Word with all prefixes: " + ans);
    }
}