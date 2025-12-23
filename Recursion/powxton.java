package Recursion;

public class powxton {
    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        // int xnm1 = power(x, n-1);
<<<<<<< HEAD
        // int xn = x * xnm1;
=======
        // int xn = x * anm1;
>>>>>>> aa93e69e9b3f0029002b85970be5b77ed3159f50
        // return xn;
        return x * power(x, n-1);
    }
    public static void main(String[] args) {
        System.out.println(power(2, 10));
    }
}
