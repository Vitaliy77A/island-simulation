package java_rush_projectt2.island.model.organizm.animal;

import java_rush_projectt2.island.map.Location;
import java_rush_projectt2.island.model.organizm.GameSimulation;
import java_rush_projectt2.island.model.organizm.plant.Grass;
import java_rush_projectt2.island.utilits.EatingTabletServise;


import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal implements GameSimulation {

    protected double weight;

    protected int maxPopulation;

    protected int maxSpeed;

    protected double foodNeeded;

    protected Location location;

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
        String animal = getClass().getSimpleName();
        Map<String, Set<GameSimulation>> residents = location.getResidents();
        for (Map.Entry<String, Set<GameSimulation>> entry : residents.entrySet()) {
            for (GameSimulation target : entry.getValue()) {
                String prey = target.getClass().getSimpleName();
                if (animal.equals(prey)) continue;
                int chans = EatingTabletServise.getChans(animal, prey);
                if (chans == 0) continue;
                int random = ThreadLocalRandom.current().nextInt(100);
                if (random < chans) {
                    if (target instanceof Grass grass) {
                        System.out.println(animal + " зїв частину " + prey +
                                " шанс " + chans + "% вірогідність " + random);
                        grass.decrease();
                        return;
                    }
                    System.out.println(animal + " зїв " + prey + " шанс " + chans + " % вірогідність " + random);
                    location.remuvOrganism(target);
                    return;
                } else {
                    System.out.println(animal + " хотів зїв " + prey + " але шанс "
                            + chans + " % вірогідністі не спрацював " + random);
                }
            }
        }

        System.out.println(animal + " не знайшов їжу");
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
