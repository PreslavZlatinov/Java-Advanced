import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        int wRow = -1;
        int wCol = -1;
        int bRow = -1;
        int bCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            char[] arr = scanner.nextLine().toCharArray();
            for (int col = 0; col < arr.length; col++) {
                matrix[row][col] = arr[col];
                if(arr[col]=='w'){
                    wRow = row;
                    wCol = col;
                } else if(arr[col]=='b'){
                    bRow = row;
                    bCol = col;
                }
            }
        }

        while (wRow != 0 && bRow != 7){
            if(wRow - 1 == bRow && (bCol == wCol-1 || bCol == wCol + 1)){
                String coordinates = getCoordinates(bRow,bCol);
                System.out.printf("Game over! White capture on %s.%n",coordinates);
                return;
            }
            wRow--;
            if(wRow == 0) {
                System.out.printf("Game over! White pawn is promoted to a queen at %s.", getCoordinates(wRow, wCol));
                return;
            }

            if(bRow + 1 == wRow && (wCol == bCol+1 || wCol == bCol -1)){
                String coordinates = getCoordinates(wRow,wCol);
                System.out.printf("Game over! Black capture on %s.%n",coordinates);
                return;
            }
            bRow++;

            if(bRow == 7){
                System.out.printf("Game over! Black pawn is promoted to a queen at %s.",getCoordinates(bRow,bCol));
                return;
            }
        }
    }

    public static String getCoordinates(int rowIndex, int colIndex){
        char[] col = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] row = new char[]{'8', '7', '6', '5', '4', '3', '2', '1'};

        StringBuilder sb = new StringBuilder();

        sb.append(col[colIndex]).append(row[rowIndex]);

        return sb.toString();
    }
}
