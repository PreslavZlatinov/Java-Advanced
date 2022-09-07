package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Person> getPersonList() {
        return roster;
    }


    public void add(Person person) {
        if(getCount() < capacity){
            roster.add(person);
        }
    }

    public int getCount() {
        return this.roster.size();
    }

    public boolean remove(String name) {
        for (Person p : roster) {
            if(p.getName().equals(name)){
                roster.remove(p);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : roster) {
            if(person.getName().equals(name) && person.getHometown().equals(hometown)){
                return person;
            }
        }
        return null;
    }

    public String getStatistics() {
        String home = String.format("The people in the hotel %s are:%n",this.name);

        StringBuilder info = new StringBuilder();

        info.append(home);
        for (Person person : roster) {
            String personInfo = String.format("Person %s: %d, Age: %d, Hometown: %s%n",person.getName(),person.getId(),person.getAge(),person.getHometown());
            info.append(personInfo);
        }

        return info.toString();
    }
}
