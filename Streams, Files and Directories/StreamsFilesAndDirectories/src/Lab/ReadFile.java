package Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);

            int oneByte = inputStream.read();

            while (oneByte >= 0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));

                oneByte = inputStream.read();
            }

        } catch (IOException ignored){

        }
    }
}
