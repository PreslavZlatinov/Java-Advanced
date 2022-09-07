package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        Map<String, String> nameMail = new LinkedHashMap<>();

        while (!name.equals("stop")){
            String email = scanner.nextLine();

            if(!email.contains(".uk") && !email.contains(".us") && !email.contains(".com")){
                nameMail.put(name,email);
            }

            name = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : nameMail.entrySet()) {
            System.out.printf("%s -> %s\n",entry.getKey(),entry.getValue());
        }

    }
}
