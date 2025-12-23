package HashMap;
import java.util.*;

public class LinkedHashset {
    public static void main(String args[]) {
        // LinkedHashSet maintains insertion order
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Bengaluru");

        System.out.println("LinkedHashSet: " + lhs);

        // TreeSet stores elements in sorted order
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Noida");
        ts.add("Mumbai");
        ts.add("Bengaluru");

        System.out.println("TreeSet: " + ts);
    }
}
