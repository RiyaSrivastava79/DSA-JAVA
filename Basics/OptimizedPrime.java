package Basic;
import java.util.*;

public class OptimizedPrime {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false; // 0, 1, and negative numbers are not prime
        }
        for (int i = 2; i <= Math.sqrt(n); i++) { 
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(isPrime(12)); // false
        System.out.println(isPrime(7));  // true
        System.out.println(isPrime(1));  // false
    }
}
