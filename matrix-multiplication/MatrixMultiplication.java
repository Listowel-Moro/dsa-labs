import java.util.Scanner;
import java.util.Arrays;

class MatrixMultiplication{
    // Global scanner to be used by all methods
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int numRowsA, numColsA, numRowsB, numColsB;

        // Take dimensions of both matrices from user
        int[] dimensions = takeMatrixDimensions();
        numRowsA = dimensions[0];
        numColsA = dimensions[1];
        numRowsB = dimensions[2];
        numColsB = dimensions[3];

        // Take matrix A input from user
        System.out.println("Enter the elements of matrix A below.");
        int[][] matrixA = takeMatrixInput(numRowsA, numColsA);

        // Take matrix A input
        System.out.println("Enter the elements of matrix B below.");
        int[][] matrixB = takeMatrixInput(numRowsB, numColsB);

        // Perform matrix multiplication
        int [][] product = multiplyMatrix(matrixA, numRowsA, numColsA, matrixB, numRowsB, numColsB);

        // Display result matrix in a table format
        System.out.println();
        System.out.println("Matrix A");
        printMatrix(matrixA);
        System.out.println("Matrix B");
        printMatrix(matrixB);
        System.out.println();
        System.out.println("Product Matrix");

        printMatrix(product);
        System.out.println();

    }

    public static int[] takeMatrixDimensions(){
        /**
         * A function to take the dimensions of the two matrices
         * Returns the dimensions as an array of integers
         */
        int[] dimensions = new int[4];

        //Take Dimensions of matrix A
        System.out.println("Please enter the number of rows of matrix A: ");
        dimensions[0] = scanner.nextInt();

        System.out.println("Please enter the number of columns of matrix A: ");
        dimensions[1] = scanner.nextInt();

        // Take Dimensions of matrix B
        System.out.println("Please enter the number of rows of matrix B: ");
        dimensions[2] = scanner.nextInt();

        System.out.println("Please enter the number of columns of matrix B: ");
        dimensions[3] = scanner.nextInt();

        return dimensions;
    };

    public static int[][] takeMatrixInput(int numRows, int numCols){
        /**
         * Function to receive matrix input from user
         * Takes the number of rows and cols and returns the received matrix
         */
        int[][] matrix = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                System.out.println("Enter matrix[" + i + "][" + j + "]");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    public static int[][] multiplyMatrix(int[][] matrixA, int numRowsA, int numColsA, int[][] matrixB, int numRowsB, int numColsB){
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
            int[] row = matrixA[i];
            for (int j = 0; j < numColsB; j++){
                // Extract matrix B's col
                int[] col = new int[numRowsB];
                for (int k = 0; k < numRowsB; k++){
                    col[k] = matrixB[k][j];
                }
                // Multiply mat A row by mat B col
                int productElement = 0;
                for (int l = 0; l < numRowsB; l++){
                    productElement += row[l] * col[l];
                }

                product[i][j] = productElement;
            }
        }

        return product;
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}