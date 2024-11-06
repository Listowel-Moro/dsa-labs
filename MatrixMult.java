import java.util.Scanner;
import java.util.Arrays;

class MatrixMult{
    // Global scanner to be used by all methods
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int numRowsA, numColsA, numRowsB, numColsB;

        // Take dimensions of both matrices from user
        int[] dims = takeDimensions();
        numRowsA = dims[0];
        numColsA = dims[1];
        numRowsB = dims[2];
        numColsB = dims[3];

        // Take matrix A input from user
        System.out.println("Enter the elements of matrix A below.");
        int[][] matA = inputMatrix(numRowsA, numColsA);

        // Take matrix A input
        System.out.println("Enter the elements of matrix B below.");
        int[][] matB = inputMatrix(numRowsB, numColsB);

        // Perform matrix multiplication
        int [][] product = mult(matA, numRowsA, numColsA, matB, numRowsB, numColsB);

        // Display result matrix in a table format
        for (int i = 0; i < numRowsA; i++){
            for (int j = 0; j < numColsB; j++){
                System.out.print(product[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[] takeDimensions(){
        /**
         * A function to take the dimensions of the two matrices
         * Returns the dimensions as an array of integers
         */
        int[] dims = new int[4];

        //Take Dimensions of matrix A
        System.out.println("Please enter the number of rows of matrix A: ");
        dims[0] = sc.nextInt();

        System.out.println("Please enter the number of columns of matrix A: ");
        dims[1] = sc.nextInt();

        // Take Dimensions of matrix B
        System.out.println("Please enter the number of rows of matrix B: ");
        dims[2] = sc.nextInt();

        System.out.println("Please enter the number of columns of matrix B: ");
        dims[3] = sc.nextInt();

        return dims;
    };

    public static int[][] inputMatrix(int numRows, int numCols){
        /**
         * Function to receive matrix input from user
         * Takes the number of rows and cols and returns the received matrix
         */
        int[][] matrix = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                System.out.println("Enter matrix[" + i + "][" + j + "]");
                matrix[i][j] = sc.nextInt();
            }
        }

        return matrix;
    }

    public static int[][] mult(int[][] matA, int numRowsA, int numColsA, int[][] matB, int numRowsB, int numColsB){
        /**
         * Function to multiply two matrices
         * Takes in the two matrices and their dimensions and returns their product
         */

        // Check to see if the two matrices are multiplicable
        if (numColsA != numRowsB){
            System.out.println("Error! These matrices cannot be mutltiplied!");
            return null;
        }

        int[][] product = new  int[numRowsA][numColsB];

        for (int i = 0; i < numRowsA; i++){
            //Extract matrix A's row
            int[] row = matA[i];
            for (int j = 0; j < numColsB; j++){
                // Extract matrix B's col
                int[] col = new int[numRowsB];
                for (int k = 0; k < numRowsB; k++){
                    col[k] = matB[k][j];
                }
                // Multiply mat A row by mat B col
                int cur = 0;
                for (int l = 0; l < numRowsB; l++){
                    cur += row[l] * col[l];
                }

                product[i][j] = cur;
            }
        }

        return product;
    }
}