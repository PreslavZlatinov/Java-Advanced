package Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> peoples = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Party!")){

            String[] commandArr = command.split("\\s+");

            String operation = commandArr[0];
            String positionToSearch = commandArr[1];
            String nameSubString = commandArr[2];

            Predicate<String> predicate = getPredicate(positionToSearch,nameSubString);

            switch (operation){
                case "Remove":
                    peoples.removeIf(predicate);
                    break;
                case "Double":
                    List<String> toDouble = peoples.stream().filter(predicate).collect(Collectors.toList());
                    peoples.addAll(toDouble);

                    break;
            }

            command = scanner.nextLine();
        }

        if(peoples.isEmpty()){
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(peoples);
            String toPrint = String.join(", ", peoples) + " are going to the party!";
            System.out.println(toPrint);
        }
    }

    private static Predicate<String> getPredicate(String positionToSearch, String nameSubString) {
        Predicate <String> predicate = null;

        switch (positionToSearch){
            case "StartsWith":
                predicate = name -> name.startsWith(nameSubString);
                break;

            case "EndsWith":
                predicate = name -> name.endsWith(nameSubString);
                break;

            case "Length":
                predicate = name -> name.length() == Integer.parseInt(nameSubString);
                break;
        }

        return predicate;
    }
}
