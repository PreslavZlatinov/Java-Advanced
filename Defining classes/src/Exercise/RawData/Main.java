package Exercise.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        //"{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure}
        // {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}",

        while (n-- > 0){
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];

            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            Engine engine = new Engine(engineSpeed,enginePower);

            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];
            Cargo cargo = new Cargo(cargoWeight,cargoType);


            List<Tire> tires = new ArrayList<>();
            for (int i = 5; i < carInfo.length; i+=2) {
                double tirePressure = Double.parseDouble(carInfo[i]);
                int tireAge = Integer.parseInt(carInfo[i+1]);

                Tire tire = new Tire(tirePressure,tireAge);

                tires.add(tire);
            }

            Car car = new Car(model,engine,cargo,tires);
            cars.add(car);
        }

        String command = scanner.nextLine();

        if(command.equals("fragile")){
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals("fragile"))
                    .filter(car -> car.getTires().stream().anyMatch(tire -> tire.getPressure() < 1))
                    .forEach(car -> System.out.println(car.getModel()));
        } else{
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals("flamable"))
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));
        }
    }
}
