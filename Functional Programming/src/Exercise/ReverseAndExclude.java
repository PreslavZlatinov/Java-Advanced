package Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> exclude = num -> num % n != 0;

        List<Integer> numList = Arrays.stream(inputLine.split("\\s+"))
                .map(Integer::parseInt)
                .filter(exclude)
                .collect(Collectors.toList());

        Consumer<Integer> print = s -> System.out.print(s + " ");

        Collections.reverse(numList);
        numList.forEach(print);
    }
}
