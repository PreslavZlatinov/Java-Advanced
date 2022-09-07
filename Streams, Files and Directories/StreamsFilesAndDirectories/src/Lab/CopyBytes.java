package Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyBytes {
    public static void main(String[] args) {
        String path = "input.txt";

        try{
            FileInputStream inputStream = new FileInputStream(path);
            FileOutputStream outputStream = new FileOutputStream("output_P3.txt");

            PrintWriter writer = new PrintWriter(outputStream);

            int read = inputStream.read();
            while (read != -1) {

                if(read == ' '){
                    writer.print(' ');
                } else if(read == 10){
                    writer.println();
                } else{
                    writer.print(read);
                }

                read = inputStream.read();
            }

            writer.close();

        } catch (IOException ignored){

        }
    }
}
