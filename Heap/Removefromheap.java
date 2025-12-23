package Heap;
import java.util.*;
public class Removefromheap {


    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        // Add element to heap (O(log n))
        public void add(int data) {
            arr.add(data); // add at last index
            int x = arr.size() - 1; // child index
            int par = (x - 1) / 2; // parent index

            // Fix heap property
            while (x > 0 && arr.get(x) < arr.get(par)) {
                // swap child and parent
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        // Return min element
        public int peek() {
            return arr.get(0);
        }

        // Heapify subtree rooted at i (O(log n))
        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if (minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                // recursive heapify
                heapify(minIdx);
            }
        }

        // Remove and return min element (O(log n))
        public int remove() {
            if (arr.size() == 0)
                throw new NoSuchElementException("Heap is empty");

            int data = arr.get(0);

            // Step 1: swap first and last
            int lastIdx = arr.size() - 1;
            int temp = arr.get(0);
            arr.set(0, arr.get(lastIdx));
            arr.set(lastIdx, temp);

            // Step 2: remove last
            arr.remove(arr.size() - 1);

            // Step 3: heapify root
            if (arr.size() > 0) heapify(0);

            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String args[]) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}