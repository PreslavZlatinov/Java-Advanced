package Exercise.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person> peoples = new ArrayList<>();

        while (!input.equals("END")){

            String[] data = input.split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String city = data[2];

            Person person = new Person(name,age,city);

            peoples.add(person);

            input = scanner.nextLine();
        }

        int compareIndex = Integer.parseInt(scanner.nextLine());
        Person comparePerson = peoples.get(compareIndex-1);

        int totalPeople = peoples.size();
        int different = 0;
        int same = 0;

        for (Person person : peoples) {
            if(person.compareTo(comparePerson) == 0){
                same++;
            } else {
                different++;
            }
        }

        if(same == 1){
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", same,different,totalPeople);
        }
    }
}
