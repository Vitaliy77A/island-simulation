package java_rush_projectt2.island.model.organizm.animal.herbivore;

import java_rush_projectt2.island.model.organizm.animal.Animal;

public abstract class Herbivore extends Animal  {
    public Herbivore(double weight, int maxPopulation, int maxSpeed, double foodNeeded) {
        super(weight, maxPopulation, maxSpeed, foodNeeded);
    }
}
