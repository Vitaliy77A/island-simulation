package java_rush_projectt2.island.model.animal;

public abstract class Animal {
    protected double weight;

    protected int maxCount;

    protected int speed;

    protected double foodNeeded;

    public Animal(double weight, int maxCount, int speed, double foodNeeded) {
        this.weight = weight;
        this.maxCount = maxCount;
        this.speed = speed;
        this.foodNeeded = foodNeeded;
    }

    public abstract void move();

    public abstract void eat();

    public abstract void reproduce();

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setFoodNeeded(double foodNeeded) {
        this.foodNeeded = foodNeeded;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public int getSpeed() {
        return speed;
    }

    public double getFoodNeeded() {
        return foodNeeded;
    }
}
