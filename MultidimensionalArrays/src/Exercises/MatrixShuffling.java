package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split("\\s+");
            matrix[row] = arr;
        }

        String command = scanner.nextLine();

        while(!command.equals("END")){

            String[] commandArr = command.split("\\s+");

            if(!commandArr[0].equals("swap")){
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }

            int row1 = Integer.parseInt(commandArr[1]);
            int col1 = Integer.parseInt(commandArr[2]);
            int row2 = Integer.parseInt(commandArr[3]);
            int col2 = Integer.parseInt(commandArr[4]);

            boolean isInvalid = false;

            if(row1 > rows || row2 > rows || row1 < 0 || row2 < 0 || col1 > cols || col2 > cols || col1 < 0 || col2 <0){
                isInvalid = true;
            }

            if(commandArr.length != 5 || isInvalid){
                System.out.println("Invalid input!");
            } else{
                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;

                printMatrix(matrix);
            }


            command = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0;  row < matrix.length; row++) {
            String[] arr = matrix[row];
            for (String s : arr) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
