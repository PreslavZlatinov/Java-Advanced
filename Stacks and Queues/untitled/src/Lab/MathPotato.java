package Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue,kids);

        int count = 0;

        while (queue.size() > 1){
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            count++;
            if(isPrime(count)) {
                System.out.println("Prime " + queue.peek());
            } else{
                System.out.println("Removed " + queue.poll());
            }
        }
        System.out.println("Last is " + queue.poll());


    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}


