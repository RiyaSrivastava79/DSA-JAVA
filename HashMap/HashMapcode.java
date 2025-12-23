package HashMap;
import java.util.*;

public class HashMapcode {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;
        private LinkedList<Node>[] buckets;
        private int numBuckets;
        private static final double LOAD_FACTOR = 0.75;

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.numBuckets = 4;
            this.size = 0;
            this.buckets = new LinkedList[numBuckets];
            for (int i = 0; i < numBuckets; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hashCode = key.hashCode();
            return Math.abs(hashCode) % numBuckets;
        }

        // Search in bucket linked list, return index of node or -1
        private int searchInLL(int bi, K key) {
            LinkedList<Node> bucket = buckets[bi];
            for (int di = 0; di < bucket.size(); di++) {
                if (bucket.get(di).key.equals(key)) {
                    return di;
                }
            }
            return -1;
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(bi, key);

            if (di == -1) {
                // Key not found, add new node
                buckets[bi].add(new Node(key, value));
                size++;

                double loadFactor = (1.0 * size) / numBuckets;
                if (loadFactor > LOAD_FACTOR) {
                    rehash();
                }
            } else {
                // Key found, update value
                buckets[bi].get(di).value = value;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(bi, key);

            if (di != -1) {
                return buckets[bi].get(di).value;
            }
            return null;
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(bi, key);
            return di != -1;
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(bi, key);

            if (di != -1) {
                Node node = buckets[bi].remove(di);
                size--;
                return node.value;
            }
            return null;
        }

        public int size() {
            return size;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            int oldNumBuckets = numBuckets;

            numBuckets = 2 * numBuckets;
            buckets = new LinkedList[numBuckets];
            for (int i = 0; i < numBuckets; i++) {
                buckets[i] = new LinkedList<>();
            }

            size = 0;

            for (int bi = 0; bi < oldNumBuckets; bi++) {
                for (Node node : oldBuckets[bi]) {
                    put(node.key, node.value);
                }
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        System.out.println("Size: " + hm.size());

        System.out.println("India: " + hm.get("India"));
        System.out.println("Contains China? " + hm.containsKey("China"));

        hm.put("China", 180);
        System.out.println("Updated China: " + hm.get("China"));

        System.out.println("Removing US: " + hm.remove("US"));
        System.out.println("Contains US? " + hm.containsKey("US"));
        System.out.println("Size after removal: " + hm.size());
    }
}
