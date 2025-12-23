<<<<<<< HEAD

=======
package Trie;
>>>>>>> aa93e69e9b3f0029002b85970be5b77ed3159f50

public class CreateTrie {
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

    public static void main(String args[]) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};
    }
}