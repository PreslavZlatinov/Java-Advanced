package Exercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> nameDeck = new LinkedHashMap<>();

        String input = scanner.nextLine();

        int[] powerArr = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};

        while (!input.equals("JOKER")){

            String[] arr = input.split(": ");
            String name = arr[0];
            String cards = arr[1];

            String[] cardsArr = cards.split(", ");

            if(nameDeck.containsKey(name)){
                for (int i = 0; i < cardsArr.length; i++) {
                    if(!nameDeck.get(name).contains(cardsArr[i])){
                        nameDeck.get(name).add(cardsArr[i]);
                    }
                }
            } else{
                nameDeck.put(name, new ArrayList<>());
                for (int i = 0; i < cardsArr.length; i++) {
                    if(!nameDeck.get(name).contains(cardsArr[i])){
                        nameDeck.get(name).add(cardsArr[i]);
                    }
                }
            }

            input = scanner.nextLine();
        }


        for (Map.Entry<String, List<String>> entry : nameDeck.entrySet()) {
            int cardSum = 0;
            for (String s : entry.getValue()) {
                int type = 0;
                int power = 0;

                String powerCheck = "";
                String typeCheck = "";

                if(s.length()>2){
                    powerCheck = "" + s.charAt(0) + s.charAt(1);
                    typeCheck = "" + s.charAt(s.length()-1);
                } else{
                    powerCheck = s.charAt(0) + "";
                    typeCheck = "" + s.charAt(1);
                }

                switch (typeCheck){
                    case "S":
                        type = 4;
                    break;
                    case "H":
                        type = 3;
                        break;
                    case "D":
                        type = 2;
                        break;
                    case "C":
                        type = 1;
                        break;
                }

                switch (powerCheck){
                    case "J":
                        power = 11;
                        break;
                    case "Q":
                        power = 12;
                        break;
                    case "K":
                        power = 13;
                        break;
                    case "A":
                        power = 14;
                        break;
                    default:
                        power = Integer.parseInt(powerCheck);
                        break;
                }

                cardSum += power * type;
            }

            System.out.printf("%s: %d\n",entry.getKey(), cardSum);

        }

    }
}
