package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][];

        List<Integer> printMatrix = new ArrayList<>();
        int rowLength = 0;
        for (int row = 0; row < n; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
            rowLength = matrix[row].length;
        }

        int[] wrongValues = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int wrongNumber = matrix[wrongValues[0]][wrongValues[1]];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(wrongNumber == matrix[row][col]){
                    int aroundSum = 0;
                    if(row - 1 >= 0 && matrix[row-1][col] != wrongNumber){
                        aroundSum += matrix[row-1][col];
                    }

                    if(row + 1 < matrix.length && matrix[row+1][col] != wrongNumber){
                        aroundSum += matrix[row+1][col];
                    }

                    if(col + 1 < matrix[row].length && matrix[row][col+1] != wrongNumber){
                        aroundSum += matrix[row][col+1];
                    }

                    if(col - 1 < matrix[row].length && col-1 >= 0 && matrix[row][col-1] != wrongNumber){
                        aroundSum += matrix[row][col-1];
                    }
                    printMatrix.add(aroundSum);
                } else{
                    printMatrix.add(matrix[row][col]);
                }
            }
        }

        int count = rowLength;

        for (int i = 0; i < printMatrix.size(); i++) {
            if(count != 0){
                System.out.print(printMatrix.get(i) + " ");
                count--;
            } else{
                System.out.println();
                count = rowLength;
                i--;
            }
        }
    }

    private static int[][] cloneMatrix(int[][] matrix) {
        int[][] matrixClone = new int[matrix.length][];
        for (int row = 0; row < matrix.length; row++) {
            matrixClone[row] = matrix[row];
        }
        return matrixClone;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
