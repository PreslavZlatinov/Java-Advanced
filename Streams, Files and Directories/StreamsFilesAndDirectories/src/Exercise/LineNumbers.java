package Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) {

        String path = "D:\\SoftUni\\Java-Advanced\\Уроци\\4. Streams, Files and Directories\\" +
                "Упражнение\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(path));

            BufferedWriter writer = new BufferedWriter(new FileWriter("output_Exr5.txt"));

            String line = reader.readLine();

            int count = 0;

            while (line != null) {
                count++;
                line = count + ". " + line;

                writer.write(line);
                writer.newLine();


                line = reader.readLine();
            }

            writer.close();
        } catch (IOException ignored) {
        }
    }
}
