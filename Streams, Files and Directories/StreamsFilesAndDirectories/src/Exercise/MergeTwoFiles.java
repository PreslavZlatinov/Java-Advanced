package Exercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeTwoFiles {
    public static void main(String[] args) {
        try {

            Scanner firstReader = new Scanner(new FileReader("D:\\SoftUni\\Java-Advanced\\Уроци\\" +
                    "4. Streams, Files and Directories\\Упражнение\\" +
                    "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));

            Scanner secondReader = new Scanner(new FileReader("D:\\SoftUni\\Java-Advanced\\Уроци\\" +
                    "4. Streams, Files and Directories\\Упражнение\\" +
                    "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));

            PrintWriter writer = new PrintWriter("output_Exr7.txt");

            while (firstReader.hasNext()){
                String text = firstReader.next();
                writer.write(text);
                writer.println();
            }

            while (secondReader.hasNext()){
                String text = secondReader.next();
                writer.write(text);
                writer.println();
            }

            writer.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
