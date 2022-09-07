package Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotationAngle = scanner.nextLine();

        String text = scanner.nextLine();

        List<String> list = new ArrayList<>();

        int maxLength = Integer.MIN_VALUE;

        while(!text.equals("END")){

            int currLength = text.length();

            if(currLength>maxLength){
                maxLength = currLength;
            }

            list.add(text);

            text = scanner.nextLine();
        }

        int rows = list.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < list.size(); i++) {
            String currText = list.get(i);
            for (int j = 0; j < currText.length(); j++) {
                if(j < maxLength){
                    matrix[i][j] = currText.charAt(j);
                } else{
                    matrix[i][j] = ' ';
                }
            }
        }

        String angleString = rotationAngle.split("[()]")[1];
        int angle = Integer.parseInt(angleString);
        int angleOfRotation = angle % 360;

        printMatrix(matrix,rows,cols, angleOfRotation);
    }

    private static void printMatrix(char[][] matrix, int rows, int cols, int angleOfRotation) {
        switch (angleOfRotation){
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;

            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows-1; row >= 0 ; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;

            case 180:
                for (int row = 0; row < rows; row++) {
                    for (int col = cols-1; col >= 0 ; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;

            case 270:
                for (int row = rows-1; row >= 0 ; row--) {
                    for (int col = cols-1; col >= 0 ; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}
