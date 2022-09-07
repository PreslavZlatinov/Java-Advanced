package Exercise.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String,Person> personMap = new HashMap<>();

        while (!input.equals("End")){

            String[] information = input.split("\\s+");

            String personName = information[0];
            String infoType = information[1];

            personMap.putIfAbsent(personName, new Person(personName));

            Person person = null;

            switch (infoType){
                case "company":
                    String companyName = information[2];
                    String department = information[3];
                    double salary = Double.parseDouble(information[4]);

                    Company company = new Company(companyName,department,salary);

                    personMap.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = information[2];
                    String pokemonType = information[3];

                    Pokemon pokemon = new Pokemon(pokemonName,pokemonType);

                    personMap.get(personName).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = information[2];
                    String parentBirthday = information[3];

                    Parent parent = new Parent(parentName,parentBirthday);

                    personMap.get(personName).getParents().add(parent);
                    break;
                case "children":
                    String childName = information[2];
                    String childBirthday = information[3];

                    Children children = new Children(childName,childBirthday);

                    personMap.get(personName).getChildren().add(children);
                    break;
                case "car":
                    String carModel = information[2];
                    int carSpeed = Integer.parseInt(information[3]);

                    Car car = new Car(carModel,carSpeed);

                    personMap.get(personName).setCar(car);
                    break;
            }

            input = scanner.nextLine();
        }

        String nameToPrint = scanner.nextLine();

        for (Map.Entry<String, Person> entry : personMap.entrySet()) {
            if(entry.getKey().equals(nameToPrint)){
                System.out.println(nameToPrint);

                System.out.println("Company:");
                if(entry.getValue().getCompany() != null) {
                    System.out.printf("%s %s %.2f%n", entry.getValue().getCompany().getName(),
                            entry.getValue().getCompany().getDepartment(),
                            entry.getValue().getCompany().getSalary());
                }

                System.out.println("Car:");
                if(entry.getValue().getCar() != null) {
                    System.out.printf("%s %d%n", entry.getValue().getCar().getModel(), entry.getValue().getCar().getSpeed());
                }

                System.out.println("Pokemon:");
                if(entry.getValue().getPokemons().size() != 0) {
                    for (Pokemon pokemon : entry.getValue().getPokemons()) {
                        System.out.printf("%s %s%n", pokemon.getName(), pokemon.getType());
                    }
                }

                System.out.println("Parents:");
                if(entry.getValue().getParents().size() != 0) {
                    for (Parent parent : entry.getValue().getParents()) {
                        System.out.printf("%s %s%n", parent.getName(), parent.getBirthday());
                    }
                }

                System.out.println("Children:");
                if(entry.getValue().getChildren().size() != 0) {
                    for (Children child : entry.getValue().getChildren()) {
                        System.out.printf("%s %s%n", child.getName(), child.getBirthday());
                    }
                }
            }
        }

    }
}
