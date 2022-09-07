package Exercise.GenericBox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public List<T> getElements() {
        return elements;
    }

    public void add(T element){
        this.elements.add(element);
    }

    public void swap(int pos1, int pos2){
        T firstElement = elements.get(pos1);
        T secondElement = elements.get(pos2);

        elements.remove(secondElement);
        elements.add(pos2,firstElement);

        elements.remove(firstElement);
        elements.add(pos1,secondElement);

    }

    public int countGreaterThan(T element){
        int count = 0;
        for (T elem : elements) {
            if(elem.compareTo(element) > 0){
                count++;
            }
        }

        return count;
    }

    public void remove(int index){
        elements.remove(index);
    }

    public void printElements() {
        for (T element : elements) {
            System.out.println(element);
        }
    }

    public boolean contains(T element){
        return elements.contains(element);
    }

    public T getMax(){
       return elements.stream().max(Comparator.naturalOrder()).get();
    }

    public T getMin(){
        return elements.stream().min(Comparator.naturalOrder()).get();
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();

        for (T element : elements) {
            sb.append(String.format("%s%n",element.toString()));
        }

        return sb.toString();
    }
}
