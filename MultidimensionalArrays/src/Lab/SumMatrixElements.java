package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
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

        System.out.println(rows);
        System.out.println(cols);

        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
            for (int i = 0; i < arr.length; i++) {
                sum+= arr[i];
            }
        }

        System.out.println(sum);
    }
}
