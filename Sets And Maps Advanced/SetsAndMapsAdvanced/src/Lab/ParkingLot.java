package Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> carNumbers = new LinkedHashSet<>();

        String input = scanner.nextLine();

        while (!input.equals("END")){

            String[] inputArr = input.split(", ");

            String command = inputArr[0];
            String carNumber = inputArr[1];

            if(command.equals("IN")){
                carNumbers.add(carNumber);
            } else{
                carNumbers.remove(carNumber);
            }


            input = scanner.nextLine();
        }

        if(carNumbers.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else{
            for (String carNumber : carNumbers) {
                System.out.println(carNumber);
            }

        }
    }
}
