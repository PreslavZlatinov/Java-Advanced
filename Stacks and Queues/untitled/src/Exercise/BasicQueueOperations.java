package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();

        String[] inputLine = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(inputLine[0]);
        int s = Integer.parseInt(inputLine[1]);
        int x = Integer.parseInt(inputLine[2]);

        String[] numbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < n; i++) {
            int digit = Integer.parseInt(numbers[i]);
            numbersQueue.offer(digit);
        }

        while (s != 0) {
            numbersQueue.poll();
            s--;
        }

        if (numbersQueue.isEmpty()) {
            System.out.println(0);
        } else {
            int minValue = Integer.MAX_VALUE;
            boolean isFound = false;
            for (Integer integer : numbersQueue) {
                if (integer == x) {
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
