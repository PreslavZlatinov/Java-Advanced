package Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllCapitals {
    public static void main(String[] args) {

        String path = "D:\\SoftUni\\Java-Advanced\\Уроци\\" +
                "4. Streams, Files and Directories\\Упражнение\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try{
            BufferedReader reader = Files.newBufferedReader(Paths.get(path));

            BufferedWriter writer = new BufferedWriter(new FileWriter("output_Exr3.txt"));

            String line = reader.readLine();

            while (line != null){
                line = line.toUpperCase();

                writer.write(line);
                writer.newLine();

                line = reader.readLine();
            }

            writer.close();
        } catch (IOException ignored){

        }
    }
}
