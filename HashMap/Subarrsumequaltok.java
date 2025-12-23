package HashMap;
import java.util.*;
public class Subarrsumequaltok {
    public static void main(String args[]) {
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;

        // (prefix sum, count)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case: sum 0 occurs once

        int sum = 0;
        int ans = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j]; // prefix sum till index j

            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println("Subarrays with sum = " + k + " : " + ans);
    }
}