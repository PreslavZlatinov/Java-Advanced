package Lab;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestedFolders {
    public static void main(String[] args) throws IOException {

        String path = "D:\\SoftUni\\Java-Advanced\\Уроци\\4. Streams, Files and Directories\\" +
                "Лекция\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

//        File root = new File("D:\\SoftUni\\Java-Advanced\\Уроци\\" +
//                "4. Streams, Files and Directories\\Лекция\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\" +
//                "Files-and-Streams");

        List<File> allDirectories = listf(path);

        for (File directory : allDirectories) {
            System.out.println(directory);
        }

        System.out.println(allDirectories.size() + "folders");

    }

    public static List<File> listf(String directoryName) {
        File directory = new File(directoryName);

        List<File> resultList = new ArrayList<File>();

        File[] fList = directory.listFiles();
        resultList.addAll(Arrays.asList(fList));
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                resultList.addAll(listf(file.getAbsolutePath()));
            }
        }
        return resultList;
    }
}
