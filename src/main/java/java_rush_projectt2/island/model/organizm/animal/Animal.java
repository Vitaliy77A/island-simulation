package java_rush_projectt2.island.model.organizm.animal;

import java_rush_projectt2.island.model.organizm.Organism;

public abstract class Animal implements Organism {

    protected double weight;

    protected int maxPopulation;

    protected int maxSpeed;

    protected double foodNeeded;

    public Animal(double weight, int maxPopulation, int maxSpeed, double foodNeeded) {
        this.weight = weight;
        this.maxPopulation = maxPopulation;
        this.maxSpeed = maxSpeed;
        this.foodNeeded = foodNeeded;
    }

    public abstract void move();

    public abstract void eat();

    public double getWeight() {
        return weight;
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getFoodNeeded() {
        return foodNeeded;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxPopulation(int maxPopulation) {
        this.maxPopulation = maxPopulation;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setFoodNeeded(double foodNeeded) {
        this.foodNeeded = foodNeeded;
    }
}
