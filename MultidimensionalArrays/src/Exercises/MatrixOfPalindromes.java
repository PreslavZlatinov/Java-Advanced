package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cols; col++) {
                char outside = (char) ('a' + row);
                char middle = (char) (outside + col);
                matrix[row][col] = "" +  outside + middle + outside;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            String[] arr = matrix[row];
            for (String s : arr) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
