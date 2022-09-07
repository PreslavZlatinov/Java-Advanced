package Lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if(studentGrades.containsKey(name)){
               studentGrades.get(name).add(grade);
            } else {
                studentGrades.put(name, new ArrayList<>());
                studentGrades.get(name).add(grade);
            }
        }

        for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {
            double gradeSum = 0;
            System.out.print(entry.getKey() + " -> ");
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("%.2f ",entry.getValue().get(i));
                gradeSum += entry.getValue().get(i);
            }
            System.out.printf("(avg: %.2f)",gradeSum/entry.getValue().size());
            System.out.println();
        }

    }
}
