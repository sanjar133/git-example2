package with_abstraction;

public abstract class Car {
    protected String name;
    protected double price;

    protected abstract void getSpeedToReach_100();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
