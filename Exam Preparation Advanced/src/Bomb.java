import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        String[] commands = scanner.nextLine().split(",");

        int sapperRow = 0;
        int sapperCol = 0;
        int bombCount = 0;

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            String[] chars = line.split("\\s+");

            for (int j = 0; j < chars.length; j++) {
                if (chars[j].equals("B")) {
                    bombCount++;
                } else if (chars[j].equals("s")) {
                    sapperRow = i;
                    sapperCol = j;
                }
            }
            matrix[i] = chars;
        }

        for (String command : commands) {
            switch (command){
                case "up":
                    if(sapperRow != 0){
                        sapperRow--;
                    }
                    break;
                case "down":
                    if(sapperRow != size -1){
                        sapperRow++;
                    }
                    break;
                case "left":
                    if(sapperCol != 0){
                        sapperCol--;
                    }
                    break;
                case "right":
                    if(sapperCol != size -1){
                        sapperCol++;
                    }
                    break;
            }

            if(matrix[sapperRow][sapperCol].equals("B")){
                System.out.println("You found a bomb!");
                matrix[sapperRow][sapperCol] = "+";
                bombCount--;
                if(bombCount == 0) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
                } else if(matrix[sapperRow][sapperCol].equals("e")){
                    System.out.printf("END! %d bombs left on the field",bombCount);
                    return;
                }
            }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombCount,sapperRow,sapperCol);
        }
    }

