package Exercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long number = Integer.parseInt(scanner.nextLine());
        System.out.println(getFibonacci(number));

    }

    public static long getFibonacci(long n){
        if(n < 2){
            return 1;
        }
        return getFibonacci(n-1) + getFibonacci(n -2);
    }
}
