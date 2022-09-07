package Exercise.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        while (n-- > 0){
            String[] engineInfo = scanner.nextLine().split("\\s+");
            String model = engineInfo[0];
            int power = Integer.parseInt(engineInfo[1]);

            Engine engine = null;

            switch (engineInfo.length){
                case 4:
                    String displacement = engineInfo[2];
                    String efficiency = engineInfo[3];
                    engine = new Engine(model,power, displacement,efficiency);
                    break;
                case 3:
                    if(engineInfo[2].matches("\\d+")){
                        String engineDisplacement = engineInfo[2];
                        engine = new Engine(model,engineDisplacement, power);
                    } else{
                        String engineEfficiency = engineInfo[2];
                        engine = new Engine(model,power,engineEfficiency);
                    }
                    break;
                case 2:
                    engine = new Engine(model,power);
                    break;
            }

            engines.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        while (m-- > 0){
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            String engineModel = carInfo[1];

            Car car = null;
            Engine engineToAdd = null;
            switch (carInfo.length){
                case 4:
                    String weight = carInfo[2];
                    String color = carInfo[3];
                    engineToAdd = engines.stream().filter(engine -> engine.getModel().equals(engineModel)).findFirst().get();
                    car = new Car(model,engineToAdd,weight,color);
                    break;
                case 3:
                    if(carInfo[2].matches("\\d+")){
                        String carWeight = carInfo[2];
                        engineToAdd = engines.stream().filter(engine -> engine.getModel().equals(engineModel)).findFirst().get();
                        car = new Car(model,carWeight,engineToAdd);
                    } else{
                        String carColor = carInfo[2];
                        engineToAdd = engines.stream().filter(engine -> engine.getModel().equals(engineModel)).findFirst().get();
                        car = new Car(model,engineToAdd,carColor);
                    }
                    break;
                case 2:
                    engineToAdd = engines.stream().filter(engine -> engine.getModel().equals(engineModel)).findFirst().get();
                    car = new Car(model,engineToAdd);
                    break;
            }

            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
