package Lab;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output_P5.txt"));

        String line = bufferedReader.readLine();

        int counter = 0;

        while (line != null){
            counter++;

            if(counter % 3 ==0){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
