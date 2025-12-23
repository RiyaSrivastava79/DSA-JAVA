package Strings;
import java.util.Scanner;
public class strings {
    public static void printLetters(String str) {
        for(int i=0; i<str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
            System.out.println();
        }
    public static void main(String[] args) {
        // char arr[] = {'a', 'b', 'c', 'd'};
        // String str = "abcd";
        // String str2 = new String("xyz@#1234");
        // // Strings are IMMUTABLE
        // Scanner sc = new Scanner(System.in);
        // String name;
        // name = sc.nextLine();
        // System.out.println(name);

        // Concatenation
        // String firstName = "Riya";
        // String lastName = "Khapra";
        // String fullName = firstName + " " + lastName;
        // System.out.println(fullName+ " is this");

        // letterlength
        String firstName = "Riya";
        String lastName = "Khapra";
        String fullName = firstName + " " + lastName;

        printLetters(fullName);

    }
}
