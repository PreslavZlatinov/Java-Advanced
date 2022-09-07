package Exercise.GenericBox;

import java.util.stream.Collectors;

public class Sorter {

    public static <T extends Comparable<T>> void sort(Box<T> box){
        box.getElements().sort(Comparable::compareTo);
    }
}
