package BitManipulation;

public class FastExponentiation {
    public static int fastExpo(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {   // agar last bit 1 hai
                ans = ans * a;
            }
            a = a * a;            // base ko square karte hain
            n = n >> 1;           // power ko 2 se divide karte hain
        }
        return ans; // ← loop ke baad return karein
    }

    public static void main(String args[]) {
        System.out.println(fastExpo(3, 5));
    }
}
