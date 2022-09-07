import java.util.Scanner;

public class BombAgain {

    private static int row = 0;

    private static int col = 0;

    private static boolean inField = true;

    private static int bombCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        String[] commands = scanner.nextLine().split(",");

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();

            if (line.contains("s")) {
                row = i;
                col = line.indexOf("s");
            }

            String[] chars = line.split("\\s+");

            for (String s : chars) {
                if(s.equals("B")){
                    bombCount++;
                }
            }

            matrix[i] = chars;
        }

        int currentBombs = 0;

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "up":
                    currentBombs = bombCount;
                    move(matrix, -1, 0);
                    if(currentBombs > bombCount){
                        System.out.println("You found a bomb!");
                    }
                    break;
                case "down":
                    currentBombs = bombCount;
                    move(matrix, 1, 0);
                    if(currentBombs > bombCount){
                        System.out.println("You found a bomb!");
                    }
                    break;
                case "left":
                    currentBombs = bombCount;
                    move(matrix, 0, -1);
                    if(currentBombs > bombCount){
                        System.out.println("You found a bomb!");
                    }
                    break;
                case "right":
                    currentBombs = bombCount;
                    move(matrix, 0, 1);
                    if(currentBombs > bombCount){
                        System.out.println("You found a bomb!");
                    }
                    break;
            }

            if(bombCount == 0){
                System.out.println("Congratulations! You found all bombs!");
                return;
            } else if(!inField){
                System.out.printf("END! %d bombs left on the field",bombCount);
                return;
            }
        }

         if (bombCount > 0 && inField) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombCount,row,col);
        }
    }

    private static void move(String[][] matrix, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        if(!isInBound(matrix,nextRow,nextCol)){
            return;
        }

        if(matrix[nextRow][nextCol].equals("B")){
            matrix[nextRow][nextCol] = "+";
            bombCount--;
        } else if(matrix[nextRow][nextCol].equals("e")){
            inField = false;
        }

        row = nextRow;
        col = nextCol;
    }

    private static boolean isInBound(String[][] matrix, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix[row].length;
    }
}
