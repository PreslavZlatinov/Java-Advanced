package Lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Map<String, List<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split("\\s+");

            String continent = arr[0];
            String country = arr[1];
            String city = arr[2];

            if(map.containsKey(continent)){
                if(map.get(continent).containsKey(country)){
                    map.get(continent).get(country).add(city);
                } else{
                    map.get(continent).put(country, new ArrayList<>());
                    map.get(continent).get(country).add(city);
                }
            } else{
                map.put(continent,new LinkedHashMap<>());
                map.get(continent).put(country, new ArrayList<>());
                map.get(continent).get(country).add(city);
            }
        }

        for (Map.Entry<String, Map<String, List<String>>> e1 : map.entrySet()) {
            System.out.println(e1.getKey() + ":");
            for (Map.Entry<String, List<String>> e2 : e1.getValue().entrySet()) {
                System.out.print( "\t" + e2.getKey() + " -> ");
                for (int i = 0; i < e2.getValue().size(); i++) {
                    if(i == e2.getValue().size()-1){
                        System.out.print(e2.getValue().get(i));
                    } else {
                        System.out.print(e2.getValue().get(i) + ", ");
                    }
                }
                System.out.println();
            }

        }

    }
}
