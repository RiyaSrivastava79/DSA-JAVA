package HashMap;
import java.util.*;
public class Unionandintersec {

    public static void main(String args[]) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> set = new HashSet<>();

        // ----- UNION -----
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println("Union = " + set.size());
        System.out.println("Union elements: " + set);

        // ----- INTERSECTION -----
        set.clear();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        int count = 0;
        System.out.print("Intersection elements: ");
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                count++;
                System.out.print(arr2[i] + " ");
                set.remove(arr2[i]); // prevent counting duplicates
            }
        }
        System.out.println();
        System.out.println("Intersection = " + count);
    }
}