package Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> namePhone = new HashMap<>();

        while (!input.equals("search")){

            String[] inputArr = input.split("-");

            String name = inputArr[0];
            String phone = inputArr[1];

            namePhone.put(name,phone);

            input = scanner.nextLine();
        }

        String name = scanner.nextLine();

        while (!name.equals("stop")){

            if(namePhone.containsKey(name)){
                System.out.printf("%s -> %s\n", name, namePhone.get(name));
            } else{
                System.out.printf("Contact %s does not exist.\n",name);
            }

            name = scanner.nextLine();
        }
    }
}
