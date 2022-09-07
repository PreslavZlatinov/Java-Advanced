package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")){

            switch (command){
                case "add":
                    UnaryOperator<List<Integer>> add = list -> list.stream().map(num -> num+1).collect(Collectors.toList());
                    numbers = add.apply(numbers);
                    break;

                case "multiply":
                    UnaryOperator<List<Integer>> multiply = list -> list.stream().map(num -> num*2).collect(Collectors.toList());
                    numbers = multiply.apply(numbers);
                    break;

                case "subtract":
                    UnaryOperator<List<Integer>> subtract = list -> list.stream().map(num -> num-1).collect(Collectors.toList());
                    numbers = subtract.apply(numbers);
                    break;

                case "print":
                    Consumer<Integer> print = s -> System.out.print(s + " ");
                    numbers.forEach(print);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }
    }

}
