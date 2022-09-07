package Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        ArrayDeque<Character> brackets = new ArrayDeque<>();

        boolean isBalanced = true;

        for (int i = 0; i < inputLine.length(); i++) {
            char currentBracket = inputLine.charAt(i);

            if(currentBracket == '(' || currentBracket == '{' || currentBracket == '['){
                brackets.push(currentBracket);
            } else{
                if(!brackets.isEmpty()) {
                    char lastBracket = brackets.pop();
                    if (currentBracket == ')' && lastBracket != '(') {
                        isBalanced = false;
                        break;
                    } else if (currentBracket == ']' && lastBracket != '[') {
                        isBalanced = false;
                        break;
                    } else if (currentBracket == '}' && lastBracket != '{') {
                        isBalanced = false;
                        break;
                    }
                } else{
                    isBalanced = false;
                }
            }
        }

        if(!isBalanced){
            System.out.println("NO");
        } else{
            System.out.println("YES");
        }

    }
}
