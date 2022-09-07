package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCount() {
        return this.data.size();
    }

    public void addEgg(Egg egg) {
        if(getCount() < capacity){
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : data) {
            if(egg.getColor().equals(color)){
                data.remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        return data.stream().max(Comparator.comparingInt(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color) {
        return data.stream().filter(egg -> egg.getColor().equals(color)).findFirst().orElse(null);
    }

    public String report() {
        String material = String.format("%s basket contains:%n",this.material);

        StringBuilder info = new StringBuilder();

        info.append(material);

        for (Egg egg : data) {
            String eggInfo = String.format("%s egg, with %d strength and %s shape.%n",egg.getColor(),egg.getStrength(),egg.getShape());
            info.append(eggInfo);
        }

        return info.toString().trim();
    }

    public List<Egg> getData() {
        return data;
    }

    public void setData(List<Egg> data) {
        this.data = data;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
