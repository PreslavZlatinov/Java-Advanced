import java.util.*;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> rosesStack = new ArrayDeque<>();
        ArrayDeque<Integer> liliesQueue = new ArrayDeque<>();
        List<Integer> storedFlowers = new ArrayList<>();

        int[] lilies = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] roses = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        for (int i = roses.length-1; i >= 0 ; i--) {
            rosesStack.push(roses[i]);
        }

        for (int i = lilies.length-1; i >= 0 ; i--) {
            liliesQueue.offer(lilies[i]);
        }

        int wreaths = 0;
        int currentSize = rosesStack.size();

        for (int i = 0; i < currentSize; i++) {
            if(rosesStack.isEmpty() || liliesQueue.isEmpty()){
                break;
            }

            int rose = rosesStack.peek();
            int lilie = liliesQueue.peek();

            int valueCombined = rosesStack.peek() + liliesQueue.peek();

            if(valueCombined == 15){
                wreaths++;
                rosesStack.pop();
                liliesQueue.poll();
            } else if(valueCombined > 15){
                int newValue = liliesQueue.poll() - 2;
                liliesQueue.offer(newValue);
                i--;
            } else {
                int roseValue = rosesStack.pop();
                int liliesValue = liliesQueue.poll();
                storedFlowers.add(roseValue);
                storedFlowers.add(liliesValue);
            }
        }

        int wreathsToAdd = 0;
        int sum = 0;

        if(!storedFlowers.isEmpty()){
            for (Integer flower : storedFlowers) {
                sum += flower;
            }
        }

        wreathsToAdd = sum / 15;

        wreaths += wreathsToAdd;

        if(wreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!",wreaths);
        } else{
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }
}
