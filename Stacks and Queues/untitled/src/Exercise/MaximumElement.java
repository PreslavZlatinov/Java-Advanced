package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String commandType = command[0];

            switch (commandType) {
                case "1":
                    int numToPush = Integer.parseInt(command[1]);
                    numbers.push(numToPush);
                    break;
                case "2":
                    if (!numbers.isEmpty()) {
                        numbers.pop();
                    }
                    break;
                case "3":
                    if (numbers.isEmpty()) {
                        System.out.println(0);
                    } else {
                        int maxElement = Integer.MIN_VALUE;
                        for (Integer number : numbers) {
                            if (number > maxElement) {
                                maxElement = number;
                            }
                        }

                        System.out.println(maxElement);
                    }
                    break;
            }
        }
    }
}
