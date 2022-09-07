package Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {

        String programDir = System.getProperty("user.dir");

        String path =programDir + "\\input.txt";

        List<String> strings = Files.readAllLines(Paths.get(path))
                .stream()
                .sorted()
                .collect(Collectors.toList());

        Path outputPath = Path.of("output_P6.txt");

        Path write = Files.write(outputPath,strings);
    }
}
