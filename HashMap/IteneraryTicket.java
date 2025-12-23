package HashMap;
import java.util.*;
public class IteneraryTicket {

    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key; // starting city
            }
        }

        return null;
    }

    public static void main(String args[]) {
        HashMap<String, String> tickets = new HashMap<>();

        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);

        System.out.print("Itinerary: ");
        while (start != null) {
            System.out.print(start);
            if (tickets.containsKey(start)) {
                System.out.print(" -> ");
                start = tickets.get(start);
            } else {
                start = null;
            }
        }
    }
}