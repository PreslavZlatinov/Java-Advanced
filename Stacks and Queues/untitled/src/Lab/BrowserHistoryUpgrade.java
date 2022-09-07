package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String navigation = scanner.nextLine();

        ArrayDeque<String> backStack = new ArrayDeque<>();
        ArrayDeque<String> forwardQueue = new ArrayDeque<>();


        while (!navigation.equals("Home")) {

            if (navigation.equals("back")) {
                if (backStack.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forwardQueue.addFirst(backStack.peek());
                    backStack.pop();
                    System.out.println(backStack.peek());
                }
            } else if (navigation.equals("forward")) {
                if (forwardQueue.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardQueue.peek());
                    backStack.push(forwardQueue.pop());
                }
            } else {
                System.out.println(navigation);
                backStack.push(navigation);
                forwardQueue.clear();
            }


            navigation = scanner.nextLine();
        }
    }
}
