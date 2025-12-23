package Recursion;

public class Increaseorder {

    public static void printInc(int n) {
        // Base case
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }

        // Recursive call
        printInc(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String args[]) {
        int n = 10;
        printInc(n);
    }
}

