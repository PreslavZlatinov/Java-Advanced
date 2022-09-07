package Exercise.StrategyPattern;

import java.util.Comparator;
import java.util.Locale;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getName().length() == o2.getName().length()){
            char firstPersonChar = o1.getName().toLowerCase().charAt(0);
            char secondPersonChar = o2.getName().toLowerCase().charAt(0);
            return Character.compare(firstPersonChar,secondPersonChar);
        }

        return Integer.compare(o1.getName().length(), o2.getName().length());
    }
}
