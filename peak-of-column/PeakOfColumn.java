import java.util.Scanner;
import java.util.Arrays;

class PeakOfColumn{
    // declare a global scanner to take all inputs
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        // Take dimensions of matrix from user
        System.out.println("Please enter the number of rows of the matrix: ");
        int numRows = scanner.nextInt();

        System.out.println("Please enter the number of columns of the matrix: ");
        int numCols = scanner.nextInt();

        // call method to take matrix input from user
        int[][] matrix = takeMatrixInput(numRows, numCols);
        //int[][] testMatrix = new int[][]{{12, 2, 4}, {17, 10, 1}, {92, 80, 79}};

        // call method to find the peak columns
        findPeakCols(matrix, numRows, numCols);

    }


    public static int[][] takeMatrixInput(int numRows, int numCols){
        /**
         * method to take matrix input
         * returns the received matrix
         */
        System.out.println("Please enter the matrix elements using these guides ");

        int[][] matrix = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                System.out.print("Enter matrix[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }


    public static void findPeakCols(int[][] matrix, int numRows, int numCols){
        /**
         * method to find teh peak columns in the matrix
         * takes the matrix and its dimensions as arguments and prints the peak colums
         */
        System.out.println();
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < numRows; i++){
            // Find max value in row
            int maxInRow = Integer.MIN_VALUE;
            for (int val: matrix[i]){
                if (maxInRow < val){
                    maxInRow = val;
                }
            }

            for (int j = 0; j < numCols; j++){
                int tempElement = matrix[i][j];
                // Check for peakness in row
                if (tempElement < maxInRow){
                    continue;
                }

                // Check for peakness in col
                int[] col = new int[numRows];
                for (int k = 0; k < numRows; k++){
                    col[k] = matrix[k][j];
                }

                // Find min value in row
                int minInCol = Integer.MAX_VALUE;
                for (int val: col){
                    if (minInCol > val){
                        minInCol = val;
                    }
                }
                
                if (tempElement > minInCol){
                    continue;
                }

                System.out.println();
                System.out.println("A (" + (i + 1) + "," + (j + 1) + ") = " + tempElement);
                System.out.println();
            }
        }
    }
}