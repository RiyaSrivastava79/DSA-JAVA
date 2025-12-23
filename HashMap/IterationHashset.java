package HashMap;
import java.util.*;

public class IterationHashset {
    public static void main(String args[]) {
        HashSet<String> cities = new HashSet<>();

        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        // Iterator<String> it = cities.iterator();
        // while(it.hasNext()) {
        //     System.out.println(it.next());

        for(String city : cities){
            System.out.println(city);
        }
    }
}
