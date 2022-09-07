package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        int[][] matrix = new int[rows][cols];

        int iterations = 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = iterations;
                iterations++;
            }
        }

        String command = scanner.nextLine();

        while(!command.equals("Nuke it from orbit")){

            String[] commandArr = command.split("\\s+");

            int row = Integer.parseInt(commandArr[0]);
            int col = Integer.parseInt(commandArr[1]);
            int radius = Integer.parseInt(commandArr[2]);

            int target = matrix[row][col];

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if(matrix[r][c] == target){
                        if(r-1 >=0){
                            deleteElement(r,c,matrix);
                        }

                        if(r-2 >=0){

                        }

                        if(r+1 <= rows){

                        }

                        if(r+2 <= rows){

                        }

                        if(c-1 >= 0){

                        }

                        if(c-2 >=0){

                        }

                        if(c+1 <= cols){

                        }

                        if(c+2 <= cols){

                        }
                    }
                }
            }

            command = scanner.nextLine();
        }
    }

    private static void deleteElement(int r, int c, int[][] matrix) {

    }
}
