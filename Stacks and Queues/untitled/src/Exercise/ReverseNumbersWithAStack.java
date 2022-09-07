package Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        String inputLine = scanner.nextLine();

        String[] numbers = inputLine.split("\\s+");

        for (int i = 0; i < numbers.length; i++) {
            int digit = Integer.parseInt(numbers[i]);
            numbersStack.push(digit);
        }

        while (!numbersStack.isEmpty()){
            System.out.print(numbersStack.pop() + " ");
        }
    }
}
