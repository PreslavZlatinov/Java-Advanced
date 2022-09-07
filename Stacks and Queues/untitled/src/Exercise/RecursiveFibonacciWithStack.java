package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacciWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long number = Integer.parseInt(scanner.nextLine());

        if(number <2){
            System.out.println(1);
            return;
        }

        ArrayDeque<Long> stack = new ArrayDeque<>();

        stack.push(0l);
        stack.push(1l);

        for (int i = 1; i <= number ; i++) {
            long num1 = stack.pop();
            long num2 = stack.pop();
            stack.push(num1);
            stack.push(num1+num2);
        }

        System.out.println(stack.pop());
    }
}
