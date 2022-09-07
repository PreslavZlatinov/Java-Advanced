package Lab;

import java.util.*;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int count = 0;

        while (!firstDeck.isEmpty() && !secondDeck.isEmpty()){
            count++;

            if(count==50){
                break;
            }

            Iterator<Integer> iteratorOne = firstDeck.iterator();
            int firstCard = iteratorOne.next();
            iteratorOne.remove();

            Iterator<Integer> iteratorTwo = secondDeck.iterator();
            int secondCard = iteratorTwo.next();
            iteratorTwo.remove();

            if(firstCard>secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if(secondCard > firstCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
        }

        if(firstDeck.size() > secondDeck.size()){
            System.out.println("First player win!");
        } else if(secondDeck.size() > firstDeck.size()){
            System.out.println("Second player win!");
        } else{
            System.out.println("Draw!");
        }

    }
}
