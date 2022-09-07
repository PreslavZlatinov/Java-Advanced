import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CookingJourney {

    private static int row = 0;
    private static int col = 0;

    private static int firstPillarRow = 0;

    private static int firstPillarCol = 0;

    private static int secondPillarRow = 0;

    private static int secondPillarCol = 0;

    private static boolean isOut = false;

    private static int money = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        List<Integer> pillarIndex = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();


            if(line.contains("S")){
                row = i;
                col = line.indexOf("S");
            }

            if (line.contains("P")){
                pillarIndex.add(i);
                pillarIndex.add(line.indexOf("P"));
            }
        }

        if(!pillarIndex.isEmpty()) {
            firstPillarRow = pillarIndex.get(0);
            firstPillarCol = pillarIndex.get(1);
            secondPillarRow = pillarIndex.get(2);
            secondPillarCol = pillarIndex.get(3);
        }
        while (money < 50){

            String command = scanner.nextLine();
            switch (command){
                case "up":
                    move(matrix,-1,0);
                    break;

                case "down":
                    move(matrix,1,0);
                    break;

                case "right":
                    move(matrix,0,1);
                    break;

                case "left":
                    move(matrix,0,-1);
                    break;
            }

            if(isOut){
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }
        }

        if(money >= 50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d%n",money);

        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    private static void move(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        if(!isInBounds(matrix,nextRow,nextCol)){
            matrix[row][col] = '-';
            isOut = true;
            return;
        }

        if(Character.isDigit(matrix[nextRow][nextCol])){
            money += Integer.parseInt(String.valueOf(matrix[nextRow][nextCol]));
        } else if(matrix[nextRow][nextCol] == 'P'){
            if(nextRow == firstPillarRow && nextCol == firstPillarCol){
                matrix[nextRow][nextCol] = '-';
                matrix[secondPillarRow][secondPillarCol] = 'S';
                nextRow = secondPillarRow;
                nextCol = secondPillarCol;
            } else if (nextRow == secondPillarRow && nextCol == secondPillarCol) {
                matrix[nextRow][nextCol] = '-';
                matrix[firstPillarRow][firstPillarCol] = 'S';
                nextRow = firstPillarRow;
                nextCol = firstPillarCol;
            }
        }

        matrix[row][col] = '-';
        matrix[nextRow][nextCol] = 'S';
        row = nextRow;
        col = nextCol;
    }

    private static boolean isInBounds(char[][] matrix, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix[row].length;
    }
}
