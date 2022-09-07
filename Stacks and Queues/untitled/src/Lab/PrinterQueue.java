package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileName = scanner.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!fileName.equals("print")) {

            if (fileName.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String fileToCancel = queue.poll();
                    System.out.printf("Canceled %s\n", fileToCancel);
                }
            } else {
                queue.offer(fileName);
            }

            fileName = scanner.nextLine();
        }

        if (!queue.isEmpty()) {

            while (queue.size() > 0) {
                String file = queue.poll();
                System.out.println(file);
            }
        }
    }
}
