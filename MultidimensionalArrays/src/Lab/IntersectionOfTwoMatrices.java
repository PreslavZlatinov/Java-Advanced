package Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char [][] firstMatrix = readMatrix(scanner, rows, cols);
        char [][] secondMatrix = readMatrix(scanner, rows, cols);
        char[][] finalMatrix = compareMatrices(firstMatrix,secondMatrix);
        for (int row = 0; row < finalMatrix.length ; row++) {
            char[] arr = firstMatrix[row];
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

    }

    private static char[][] compareMatrices(char[][] firstMatrix, char[][] secondMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {
            char[] arr1 = firstMatrix[row];
            char[] arr2 = secondMatrix[row];
            for (int i = 0; i < arr1.length; i++) {
                if(arr1[i] != arr2[i]){
                    arr1[i] = '*';
                }
            }
        }
        return firstMatrix;
    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+","").toCharArray();
        }

        return matrix;
    }
}
