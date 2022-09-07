package Lab;

import java.math.BigDecimal;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

            map.put(name,new ArrayList<>());
            for (int j = 0; j < grades.length; j++) {
                map.get(name).add(grades[j]);
            }
        }

        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {

            double sumGrades = 0;
            for (Double grade : entry.getValue()) {
                sumGrades += grade;
            }
            double finalGrade = sumGrades/entry.getValue().size();
            System.out.printf("%s is graduated with %s\n", entry.getKey(), finalGrade);

        }

    }
}
