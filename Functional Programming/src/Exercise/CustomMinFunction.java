package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ints = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


       Function<int[], Integer> findTheSmallest = (int[] arr) ->{
           int smallest = Integer.MAX_VALUE;
           for (int num : ints) {
               if(num < smallest){
                   smallest = num;
               }
           }
           return smallest;
       };

        System.out.println(findTheSmallest.apply(ints));
    }
}
