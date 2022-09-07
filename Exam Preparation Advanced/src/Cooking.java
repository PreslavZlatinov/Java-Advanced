import java.util.*;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidStack = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientQueue = new ArrayDeque<>();

        int[] liquids = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] ingredients = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = liquids.length-1; i >= 0 ; i--) {
            liquidStack.push(liquids[i]);
        }

        for (int i = ingredients.length-1; i >= 0 ; i--) {
            ingredientQueue.offer(ingredients[i]);
        }

        Map<String,Integer> bakedFoods = new LinkedHashMap<>();
        bakedFoods.put("Bread",0);
        bakedFoods.put("Cake",0);
        bakedFoods.put("Fruit Pie",0);
        bakedFoods.put("Pastry",0);

        int currentSize = liquidStack.size();

        for (int i = 0; i < currentSize; i++) {

            if(liquidStack.isEmpty() || ingredientQueue.isEmpty()){
                break;
            }

            int valueSum = liquidStack.peek() + ingredientQueue.peek();

            switch (valueSum){
                case 25:
                    bakedFoods.put("Bread",bakedFoods.get("Bread")+1);
                    liquidStack.pop();
                    ingredientQueue.poll();
                    break;
                case 50:
                    bakedFoods.put("Cake",bakedFoods.get("Cake")+1);
                    liquidStack.pop();
                    ingredientQueue.poll();
                    break;
                case 75:
                    bakedFoods.put("Pastry",bakedFoods.get("Pastry")+1);
                    liquidStack.pop();
                    ingredientQueue.poll();
                    break;
                case 100:
                    bakedFoods.put("Fruit Pie",bakedFoods.get("Fruit Pie")+1);
                    liquidStack.pop();
                    ingredientQueue.poll();
                    break;

                default:
                    liquidStack.pop();
                    int ingredientValue = ingredientQueue.poll() + 3;
                    ingredientQueue.push(ingredientValue);
                    break;
            }
        }

        boolean isBaked = true;

        for (Map.Entry<String, Integer> entry : bakedFoods.entrySet()) {
            if(entry.getValue() == 0){
                isBaked = false;
                break;
            }
        }

        if(isBaked){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if(liquidStack.isEmpty()){
            System.out.println("Liquids left: none");
        } else{
            System.out.print("Liquids left: ");
            int i = 0;
            for (Integer integer : liquidStack) {
                if(i++ == liquidStack.size() - 1){
                    System.out.print(integer);
                    System.out.println();
                } else {
                    System.out.print(integer + ", ");
                }
            }

        }
        if(ingredientQueue.isEmpty()){
            System.out.println("Ingredients left: none");
        } else{
            System.out.print("Ingredients left: ");
            int i = 0;
            for (Integer integer : ingredientQueue) {
                if(i++ == ingredientQueue.size() - 1){
                    System.out.print(integer);
                    System.out.println();
                } else {
                    System.out.print(integer + ", ");
                }
            }
        }


        for (Map.Entry<String, Integer> entry : bakedFoods.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }

    }
}
