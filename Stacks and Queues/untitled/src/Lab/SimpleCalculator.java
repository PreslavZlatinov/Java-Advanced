package Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        String[] expressionSplit = expression.split("\\s+");

        ArrayDeque<String> numberStack = new ArrayDeque<>();
        Collections.addAll(numberStack,expressionSplit);

        while (numberStack.size() > 1){
            int firstNum = Integer.parseInt(numberStack.pop());
            String operation = numberStack.pop();
            int secondNum = Integer.parseInt(numberStack.pop());

            switch (operation){
                case "+":
                    numberStack.push(String.valueOf(firstNum+secondNum));
                    break;
                case "-":
                    numberStack.push(String.valueOf(firstNum-secondNum));
                    break;
            }
        }

        System.out.println(numberStack.pop());
    }
}
