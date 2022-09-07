package Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character,Integer> charCount = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            charCount.put(character,0);
            for (int j = 0; j < input.length(); j++) {
                if(character == input.charAt(j)){
                    charCount.put(character,charCount.get(character)+1);
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.printf("%c: %d time/s\n",entry.getKey(),entry.getValue());
        }

    }
}
