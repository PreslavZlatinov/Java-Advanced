package Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        int maxSum = Integer.MIN_VALUE;
        List<Integer> firstRow = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols ; col++) {
                if(row + 2 < rows && col + 2 < cols){
                    int sum = matrix[row][col] + matrix[row][col+1] + matrix[row][col+2]
                            + matrix[row+1][col] + matrix[row+1][col+1] + matrix[row+1][col+2]
                            + matrix[row+2][col] + matrix[row+2][col+1] + matrix[row+2][col+2];
                    if(maxSum< sum){
                        firstRow.clear();
                        maxSum = sum;
                        for (int r = row; r < row+3; r++) {
                            for (int c = col; c < col+3; c++) {
                                firstRow.add(matrix[r][c]);
                            }
                        }
                    }
                }
            }
        }

        System.out.print("Sum = " + maxSum);

        for (int i = 0; i < firstRow.size(); i++) {
            if(i%3==0){
                System.out.println();
            }
            System.out.print(firstRow.get(i) + " ");
        }
    }
}
