package TwoDarrays;

public class Diagonalsum {
<<<<<<< HEAD
    public static int diagonalSum(int matrix[][] ) { //O (n^2)
=======
    public static int diagonalSum(int matrix[][] ) {
>>>>>>> aa93e69e9b3f0029002b85970be5b77ed3159f50
        int sum = 0;
        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix[0].length; j++) {
        //         if(i == j) {
        //             sum += matrix[i][j];
        //         }
        //         else if(i+j == matrix.length-1){
        //             sum += matrix[i][j];
        //         }
        //     }
        // }
        for(int i=0; i<matrix.length; i++){
            sum+= matrix[i][i];
            if(i != matrix.length-1-i)
            sum+= matrix[i][matrix.length-i-1];
        }
        return sum;
        
    }
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4},
                          {5, 6, 7, 8},
                          {9, 10, 11, 12},
                          {13, 14, 15, 16}};
    System.out.println(diagonalSum(matrix));
    }
    
}
