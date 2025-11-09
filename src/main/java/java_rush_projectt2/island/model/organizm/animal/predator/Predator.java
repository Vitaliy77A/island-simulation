package java_rush_projectt2.island.model.organizm.animal.predator;

import java_rush_projectt2.island.model.organizm.animal.Animal;

public abstract class Predator extends Animal {
    public Predator(double weight, int maxPopulation, int maxSpeed, double foodNeeded) {
        super(weight, maxPopulation, maxSpeed, foodNeeded);
    }
}
