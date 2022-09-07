package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallest = list->{
          int smallest = Integer.MAX_VALUE;
          int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) <= smallest){
                    smallest = list.get(i);
                    index = i;
                }
            }
            return index;
        };

        System.out.println(findSmallest.apply(integers));
    }
}
