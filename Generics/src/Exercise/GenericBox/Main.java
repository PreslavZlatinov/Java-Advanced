package Exercise.GenericBox;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<String> box = new Box<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] inputArr = input.split("\\s+");

            switch (inputArr[0]) {
                case "Add":
                    String element = inputArr[1];
                    box.add(element);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(inputArr[1]);
                    box.remove(indexToRemove);
                    break;
                case "Contains":
                    String containsCheck = inputArr[1];
                    System.out.println(box.getElements().contains(containsCheck));
                    break;
                case "Swap":
                    int indexOne = Integer.parseInt(inputArr[1]);
                    int indexTwo = Integer.parseInt(inputArr[2]);

                    box.swap(indexOne, indexTwo);

                    break;
                case "Greater":
                    String toCompare = inputArr[1];

                    System.out.println(box.countGreaterThan(toCompare));

                    break;
                case "Max":
                    System.out.println(box.getMax());
                    break;
                case "Min":
                    System.out.println(box.getMin());
                    break;

                case "Sort":
                    Sorter.sort(box);
                    break;
                case "Print":
                    box.printElements();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
