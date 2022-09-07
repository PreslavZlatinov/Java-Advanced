package Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) {

        String path = "D:\\SoftUni\\Java-Advanced\\Уроци\\" +
                "4. Streams, Files and Directories\\Упражнение\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        Set<Character> vowels = Set.of('a','e','i','o','u');
        Set<Character> punctuation = Set.of('!',',','.','?');

        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(path));

            BufferedWriter writer = new BufferedWriter(new FileWriter("output_Exr4.txt"));

            String line  = reader.readLine();

            int vowelsCount = 0;
            int punctuationCount = 0;
            int consonantsCount = 0;

            while (line != null){

                for (char c : line.toCharArray()) {
                    if(vowels.contains(c)){
                        vowelsCount++;
                    } else if(punctuation.contains(c)){
                        punctuationCount++;
                    } else if(c != ' '){
                        consonantsCount++;
                    }
                }

                line = reader.readLine();
            }

            writer.write("Vowels: " + vowelsCount);
            writer.newLine();
            writer.write("Consonants: " + consonantsCount);
            writer.newLine();
            writer.write("Punctuation: " + punctuationCount);

            writer.close();
        } catch (IOException ignored){

        }
    }
}
