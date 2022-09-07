package Exercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Comparator<Integer> sortAll = (num1, num2) -> {
          if(num1 % 2 == 0 && num2 % 2 != 0){
              //num1 chetno num2 nechetno
              return -1;
          } else if (num1 %2 != 0 && num2 % 2 ==0) {
              //num1 nechetno num2 chetno
              return 1;
          } else{
              return num1.compareTo(num2);
          }
        };

        numbers.sort(sortAll);

        Consumer<Integer> print = s -> System.out.print(s + " ");

        numbers.forEach(print);

    }
}
