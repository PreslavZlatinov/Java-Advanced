package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");
        int n = Integer.parseInt(dimensions[0]);
        String pattern = dimensions[1];

        int[][] matrix = new int[n][n];

        if(pattern.equals("A")){
            fillMatrixA(matrix);
        } else if (pattern.equals("B")) {
           fillMatrixB(matrix);
        }

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


    private static void fillMatrixB(int[][] matrix) {
        int count = 1;
        int iterations = 0;
        for (int col = 0; col < matrix.length; col++) {
            iterations++;
            if(iterations%2==0){
                count += matrix.length-1;
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = count;
                    count--;
                }
                count += matrix.length+1;
            }else {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = count;
                    count++;
                }
            }
        }
    }

    private static void fillMatrixA(int[][] matrix) {
        int count = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = count;
                count++;
            }
        }
    }
}
