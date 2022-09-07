import java.util.*;

public class ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkStack = new ArrayDeque<>();
        ArrayDeque<Double> cacaoQueue = new ArrayDeque<>();

        double[] milk = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        double[] cacao = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        for (int i = milk.length - 1; i >= 0; i--) {
            milkStack.push(milk[i]);
        }

        for (int i = cacao.length - 1; i >= 0; i--) {
            cacaoQueue.offer(cacao[i]);
        }

        int currentSize = milkStack.size();

        Map<String,Integer> chocolates = new LinkedHashMap<>();
        chocolates.put("Baking Chocolate",0);
        chocolates.put("Dark Chocolate",0);
        chocolates.put("Milk Chocolate",0);

        for (int i = 0; i < currentSize; i++) {

            if (milkStack.isEmpty() || cacaoQueue.isEmpty()) {
                break;
            }

            double valueSum = milkStack.peek() + cacaoQueue.peek();
            String valueForSwitch = String.valueOf((cacaoQueue.peek() / valueSum) * 100);

            switch (valueForSwitch) {
                case "30.0":
                    chocolates.put("Milk Chocolate",chocolates.get("Milk Chocolate")+1);
                    milkStack.pop();
                    cacaoQueue.poll();
                    break;
                case "50.0":
                    chocolates.put("Dark Chocolate",chocolates.get("Dark Chocolate")+1);
                    milkStack.pop();
                    cacaoQueue.poll();
                    break;
                case "100.0":
                    chocolates.put("Baking Chocolate",chocolates.get("Baking Chocolate")+1);
                    milkStack.pop();
                    cacaoQueue.poll();
                    break;
                default:
                    cacaoQueue.poll();
                    double milkValue = milkStack.pop() + 10;
                    milkStack.offer(milkValue);
                    break;
            }
        }

        boolean isBaked = true;

        for (Map.Entry<String, Integer> entry : chocolates.entrySet()) {
            if(entry.getValue() == 0){
                isBaked = false;
                break;
            }
        }

        if(isBaked){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else{
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> entry : chocolates.entrySet()) {
            if(entry.getValue() != 0){
                System.out.printf("# %s --> %d%n",entry.getKey(),entry.getValue());
            }
        }

    }
}
