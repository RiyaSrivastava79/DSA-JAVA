import java.util.*;

public class DuplicateParentheses {
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Closing bracket case
            if (ch == ')') {
                int count = 0;

                // Pop elements until '(' is found
                while (s.pop() != '(') {
                    count++;
                }

                // If no content between '(' and ')', duplicate exists
                if (count < 1) {
                    return true; // duplicate parentheses found
                }
            } else {
                // Push all other characters
                s.push(ch);
            }
        }

        return false; // No duplicates found
    }

    public static void main(String[] args) {
        String str = "((a+b))"; 
        String str2 = "(a+(b)/c)";// duplicate parentheses
        System.out.println(isDuplicate(str)); //  Expected output: true
    }
}

