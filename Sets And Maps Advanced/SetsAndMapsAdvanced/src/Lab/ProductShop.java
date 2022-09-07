package Lab;

import java.util.*;
import java.util.stream.Collectors;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Map<String,Double>> map = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")){
            String[] inputArr = input.split(", ");

            String store = inputArr[0];
            String product = inputArr[1];
            double price = Double.parseDouble(inputArr[2]);

            if(map.containsKey(store)){
                map.get(store).put(product,price);
            } else{
                map.put(store,new LinkedHashMap<>());
                map.get(store).put(product,price);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> e1 : map.entrySet()) {
            System.out.println(e1.getKey() + "->");
            for (Map.Entry<String, Double> e2 : e1.getValue().entrySet()) {
                //System.out.println("Product: " + e2.getKey() + ", Price: " + e2.getValue());
                System.out.printf("Product: %s, Price: %.1f\n", e2.getKey(), e2.getValue());
            }
        }

    }
}
