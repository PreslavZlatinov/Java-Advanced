package Lab;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(inputStream);

        PrintWriter writer = new PrintWriter(new FileOutputStream("output_P4.txt"));

        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                writer.println(scanner.next());
            } else {
                scanner.next();
            }
        }

        writer.close();
    }
}
