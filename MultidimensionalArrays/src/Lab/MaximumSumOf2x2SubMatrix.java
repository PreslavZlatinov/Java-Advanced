package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }

        int maxSum = Integer.MIN_VALUE;
        List<Integer> firstRow = new ArrayList<>();
        List<Integer> secondRow = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row + 1 < rows && col + 1 < cols) {
                    int sum = matrix[row][col] + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row][col + 1];
                    if (sum > maxSum){
                        firstRow.clear();
                        secondRow.clear();
                        maxSum = sum;
                        firstRow.add(matrix[row][col]);
                        firstRow.add(matrix[row][col+1]);
                        secondRow.add(matrix[row+1][col]);
                        secondRow.add(matrix[row+1][col+1]);
                    }
                }
            }
        }

        for (Integer integer : firstRow) {
            System.out.print(integer + " ");
        }

        System.out.println();

        for (Integer integer : secondRow) {
            System.out.print(integer + " ");
        }

        System.out.println();

        System.out.println(maxSum);
    }
}
