import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Armory {

    private static int row = 0;

    private static int col = 0;

    private static int firstMirrorRow = 0;

    private static int firstMirrorCol = 0;

    private static int secondMirrorRow = 0;

    private static int secondMirrorCol = 0;

    private static boolean isOut = false;

    private static int money = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        List<Integer> mirrorIndex = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();


            if(line.contains("A")){
                row = i;
                col = line.indexOf("A");
            }

            if (line.contains("M")){
                mirrorIndex.add(i);
                mirrorIndex.add(line.indexOf("M"));
            }
        }

        if(!mirrorIndex.isEmpty()) {
            firstMirrorRow = mirrorIndex.get(0);
            firstMirrorCol = mirrorIndex.get(1);
            secondMirrorRow = mirrorIndex.get(2);
            secondMirrorCol = mirrorIndex.get(3);
        }

        while (money < 65){
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
                System.out.println("I do not need more swords!");
                break;
            }
        }

        if(money >= 65){
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n",money);

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
        } else if(matrix[nextRow][nextCol] == 'M'){
            if(nextRow == firstMirrorRow && nextCol == firstMirrorCol){
                matrix[nextRow][nextCol] = '-';
                matrix[firstMirrorRow][firstMirrorCol] = '-';
                nextRow = secondMirrorRow;
                nextCol = secondMirrorCol;
            } else if (nextRow == secondMirrorRow && nextCol == secondMirrorCol) {
                matrix[nextRow][nextCol] = '-';
                matrix[firstMirrorRow][firstMirrorCol] = '-';
                nextRow = firstMirrorRow;
                nextCol = firstMirrorCol;
            }
        }

        matrix[row][col] = '-';
        matrix[nextRow][nextCol] = 'A';
        row = nextRow;
        col = nextCol;
    }

    private static boolean isInBounds(char[][] matrix, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix[row].length;
    }
}
