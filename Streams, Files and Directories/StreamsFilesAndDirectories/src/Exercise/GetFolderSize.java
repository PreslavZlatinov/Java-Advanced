package Exercise;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class GetFolderSize {
    public static void main(String[] args) {

        File folder = new File("D:\\SoftUni\\Java-Advanced\\Уроци\\" +
                "4. Streams, Files and Directories\\Упражнение\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        Deque<File> files = new ArrayDeque<>();

        files.offer(folder);

        int totalSize = 0 ;

        while (!files.isEmpty()){
            File currentFile = files.poll();
            File[] nestedFiles = currentFile.listFiles();

            for (File nestedFile : nestedFiles) {
                if(nestedFile.isDirectory()){
                    files.offer(nestedFile);
                } else{
                    totalSize += nestedFile.length();
                }
            }
        }

        System.out.println("Folder size: " + totalSize);
    }
}
