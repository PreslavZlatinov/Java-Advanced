package Lab;

import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double,Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            double number = numbers[i];

            if(map.containsKey(number)){
                map.put(number,map.get(number)+1);
            } else{
                map.put(number,1);
            }
        }

        for (Map.Entry<Double, Integer> e : map.entrySet()) {
            System.out.printf("%.1f -> %d\n", e.getKey(), e.getValue());
        }

    }
}
