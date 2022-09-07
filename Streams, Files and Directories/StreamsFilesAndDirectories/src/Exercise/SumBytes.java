package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args){

        String path = "D:\\SoftUni\\Java-Advanced\\Уроци\\" +
                "4. Streams, Files and Directories\\Упражнение\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(path));

            String line = reader.readLine();

            long charSum = 0;

            while (line != null){
                for (char c : line.toCharArray()) {
                    charSum += c;
                }

                line = reader.readLine();
            }

            System.out.println(charSum);
        } catch (IOException ignored){

        }




    }
}
