import java.util.Collections;
import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        String[] commands = scanner.nextLine().split(",");

        int row = -1;
        int col = -1;
        int money = 0;

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            String[] chars = line.split("\\s+");

            for (int j = 0; j < chars.length; j++) {
                if (chars[j].equals("D")) {
                    row = i;
                    col = j;
                }
            }
            matrix[i] = chars;
        }

        boolean isInJail = false;

        for (String command : commands) {

            boolean wrongIndex = false;

            switch (command) {
                case "up":
                    if(row == 0){
                        wrongIndex = true;
                    } else {
                        matrix[row][col] = "+";
                        row--;
                    }
                    break;
                case "down":
                    if(row == size-1){
                        wrongIndex = true;
                    } else if (row != size - 1) {
                        matrix[row][col] = "+";
                        row++;
                    }
                    break;
                case "left":
                    if(col == 0){
                        wrongIndex = true;
                    } else {
                        matrix[row][col] = "+";
                        col--;
                    }
                    break;
                case "right":
                    if(col == size - 1){
                        wrongIndex = true;
                    } else if (col != size - 1) {
                        matrix[row][col] = "+";
                        col++;
                    }
                    break;
            }

            if(!wrongIndex) {
                if (matrix[row][col].equals("$")) {
                    matrix[row][col] = "D";
                    int moneyStolen = row * col;
                    System.out.printf("You successfully stole %d$.%n", moneyStolen);
                    money += moneyStolen;
                } else if (matrix[row][col].equals("P")) {
                    System.out.printf("You got caught with %d$, and you are going to jail.%n", money);
                    matrix[row][col] = "#";
                    isInJail = true;
                } else{
                    matrix[row][col] = "D";
                }
            } else{
                System.out.println("You cannot leave the town, there is police outside!");
            }

            if(isInJail){
                break;
            }
        }

        if(!isInJail) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", money);
        }

        for (String[] strings : matrix) {
            for (String s : strings) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
