import java.util.Scanner;

public class MouseAndCheese {

    private static int cheeseEaten = 0;
    private static int row = 0;
    private static int col = 0;

    private static boolean mouseIsInField = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();

            if(line.contains("M")){
                row = i;
                col = line.indexOf("M");
            }
        }

        String command = scanner.nextLine();


        while (!command.equals("end")) {

            switch (command){
                case "up":
                    moveMouse(matrix,-1,0);
                    break;

                case "down":
                    moveMouse(matrix,1,0);
                    break;

                case "right":
                    moveMouse(matrix,0,1);
                    break;

                case "left":
                    moveMouse(matrix,0,-1);
                    break;
            }

            if(!mouseIsInField){
                System.out.println("Where is the mouse?");
                break;
            }

            command = scanner.nextLine();
        }

        if(cheeseEaten >= 5){
            System.out.printf("Great job, the mouse is fed %d cheeses!%n",cheeseEaten);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",5-cheeseEaten);
        }

        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }


    }

    private static void moveMouse(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        boolean isBonus = false;

        if(!isInBound(matrix,nextRow,nextCol)){
            matrix[row][col] = '-';
            mouseIsInField = false;
            return;
        }

        if(matrix[nextRow][nextCol] == 'c'){
            cheeseEaten++;
        } else if(matrix[nextRow][nextCol]=='B') {
            isBonus = true;
        }

        matrix[row][col] = '-';
        matrix[nextRow][nextCol] = 'M';
        row = nextRow;
        col = nextCol;

        if(isBonus){
            moveMouse(matrix,rowMutator,colMutator);
        }
    }

    private static boolean isInBound(char[][] matrix, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix[row].length;
    }
}
