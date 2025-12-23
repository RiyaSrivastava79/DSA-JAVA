package Basic;
import java.util.*;

public class binCoefficient {

    // factorial function
    public static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        return f;
    }

    // binomial coefficient function
    public static int binCoeff(int n, int r) {
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nmr = factorial(n - r);
        int binCoeff = fact_n / (fact_r * fact_nmr);
        return binCoeff;
    }

    // main method
    public static void main(String args[]) {
        System.out.println("4! = " + factorial(4));   // factorial test
        System.out.println("C(5, 2) = " + binCoeff(5, 2)); // binomial coefficient test
    }
}
