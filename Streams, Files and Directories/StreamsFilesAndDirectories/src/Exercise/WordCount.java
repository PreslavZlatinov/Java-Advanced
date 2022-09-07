package Exercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {

        try {
            Scanner wordReader = new Scanner(new FileReader("D:\\SoftUni\\Java-Advanced\\Уроци\\" +
                    "4. Streams, Files and Directories\\Упражнение\\" +
                    "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));

            Scanner textReader = new Scanner(new FileReader("D:\\SoftUni\\Java-Advanced\\Уроци\\" +
                    "4. Streams, Files and Directories\\Упражнение\\" +
                    "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));

            PrintWriter writer = new PrintWriter("output_Exr6.txt");

            Map<String,Integer> wordCount = new LinkedHashMap<>();

            Arrays.stream(wordReader.nextLine().split("\\s+")).forEach(word -> wordCount.put(word,0));

            while (textReader.hasNext()){
                String text = textReader.next();

                if(wordCount.containsKey(text)){
                    int occurrences = wordCount.get(text);
                    occurrences++;
                    wordCount.put(text,occurrences);
                }
            }

            wordCount.entrySet().forEach(entry -> writer.printf("%s - %d\n", entry.getKey(), entry.getValue()));

            writer.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
