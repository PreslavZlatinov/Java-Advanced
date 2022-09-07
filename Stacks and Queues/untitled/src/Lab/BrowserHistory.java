package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String navigation = scanner.nextLine();

        ArrayDeque<String> navigationStack = new ArrayDeque<>();

        while (!navigation.equals("Home")){

            if(!navigation.equals("back")){
                navigationStack.push(navigation);
                System.out.println(navigation);
            } else{
                if(navigationStack.size()==1 || navigationStack.isEmpty()){
                    System.out.println("no previous URLs");
                } else{
                    navigationStack.pop();
                    String navigationToPrint = navigationStack.peek();
                    System.out.println(navigationToPrint);
                }
            }

            navigation = scanner.nextLine();
        }
    }
}
