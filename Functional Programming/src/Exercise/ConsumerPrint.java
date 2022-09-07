package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> print = System.out::println;

        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        list.forEach(print);
    }
}
