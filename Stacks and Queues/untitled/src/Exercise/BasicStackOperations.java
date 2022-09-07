package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commands = scanner.nextLine().split("\\s+");

        int numsToPush = Integer.parseInt(commands[0]);
        int numsToPop = Integer.parseInt(commands[1]);
        int numToSearch = Integer.parseInt(commands[2]);

        String[] numbers = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < numsToPush; i++) {
            int digit = Integer.parseInt(numbers[i]);
            numbersStack.push(digit);
        }

        while (numsToPop != 0) {
            numbersStack.pop();
            numsToPop--;
        }

        if (numbersStack.isEmpty()) {
            System.out.println(0);
        } else {

            int minValue = Integer.MAX_VALUE;
            boolean isFound = false;

            for (Integer integer : numbersStack) {
                if (integer == numToSearch) {
                    isFound = true;
                    System.out.println(true);
                } else {
                    if (integer < minValue) {
                        minValue = integer;
                    }
                }
            }

            if (!isFound) {
                System.out.println(minValue);
            }

        }
    }
}
