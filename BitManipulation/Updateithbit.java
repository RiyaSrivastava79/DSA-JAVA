package BitManipulation;

public class Updateithbit {

    // Method to clear the ith bit (set it to 0)
    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    // Method to set the ith bit (set it to 1)
    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    // Method to update the ith bit to newBit (0 or 1)
    public static int updateIthBit(int n, int i, int newBit) {
        if (newBit == 0) {
            return clearIthBit(n, i);
        } else {
            return setIthBit(n, i);
        }
    }

    public static void main(String args[]) {
        System.out.println(updateIthBit(10, 1, 1)); // Example: update 1st bit of 10 to 1
    }
}

