public class Item {

    private String name;
    private double value;
    private double weight;

    public Item(String name, double value, double weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", weight=" + weight +
                '}';
    }
}
