package Exercise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) {
        String path = "D:\\SoftUni\\Java-Advanced\\Уроци\\" +
                "4. Streams, Files and Directories\\Упражнение\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(path));

            String line = reader.readLine();

            while (line != null){
                long sum = 0;

                for (char s : line.toCharArray()) {
                    sum += s;
                }

                System.out.println(sum);

                line = reader.readLine();
            }

        } catch (IOException ignored){

        }
    }
}
