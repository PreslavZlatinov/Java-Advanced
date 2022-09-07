package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        int firstDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if(row==col){
                    firstDiagonal += matrix[row][col];
                }
            }
        }
        
        int secondDiagonal = 0;
        int rowCount = 0;

        for (int col = matrix.length-1; col >= 0 ; col--) {
            secondDiagonal += matrix[col][rowCount];
            rowCount++;
        }

        System.out.println(Math.abs(firstDiagonal-secondDiagonal));
    }
}
