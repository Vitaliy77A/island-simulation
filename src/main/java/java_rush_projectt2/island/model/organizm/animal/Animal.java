package java_rush_projectt2.island.model.organizm.animal;

import java_rush_projectt2.island.model.organizm.GameSimulation;

public abstract class Animal implements GameSimulation {

    protected double weight;

    protected int maxPopulation;

    protected int maxSpeed;

    protected double foodNeeded;

    @Override
    public void play() {
        move();
        eat();
        reproduce();
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " рухається по карті");
    }

    @Override
    public void eat() {
        System.out.println(getClass().getSimpleName() + " в пошуках їжі");
    }

    @Override
    public void reproduce() {
        System.out.println(getClass().getSimpleName() + " розмножується");
    }

    public Animal(double weight, int maxPopulation, int maxSpeed, double foodNeeded) {
        this.weight = weight;
        this.maxPopulation = maxPopulation;
        this.maxSpeed = maxSpeed;
        this.foodNeeded = foodNeeded;
    }



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
