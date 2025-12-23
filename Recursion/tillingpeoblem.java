package Recursion;

public class tillingpeoblem {
    public static int tillingProblem(int n){ //2xn (floor size)
        // base case
        if(n == 0 || n==1){
            return 1;
        }
        // kaam
        // verticle choice
        int fnm1 = tillingProblem(n-1);
        // horizontal choice
        int fnm2 = tillingProblem(n-2);

        int totWays = fnm1 + fnm2;
        return totWays;

}
    public static void main(String[] args) {
    System.out.println(tillingProblem(3));
    }
}
