package Exercise;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();

        int[] lengths = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < lengths[0]; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            first.add(number);
        }

        for (int i = 0; i < lengths[1]; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            second.add(number);
        }

        Set<Integer> setToPrint = new LinkedHashSet<>();

        for (Integer integer : first) {
            if(second.contains(integer)){
                setToPrint.add(integer);
            }
        }

        for (Integer integer : setToPrint) {
            System.out.print(integer + " ");
        }

    }
}
