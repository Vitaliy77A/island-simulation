package java_rush_project2.island.model_organism.animal;

import java_rush_project2.island.model_organism.Eating;
import java_rush_project2.island.model_organism.Organism;
import java_rush_project2.island.model_organism.plant.Grass;
import java_rush_project2.island.utilits.EatingTable;
import java_rush_project2.island.utilits.factory.OrganismConfig;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal implements Eating,Organism {

    private final OrganismConfig config;
    private volatile double currentSatiety;
    private volatile int age = 0;


    public void setCurrentSatiety(double currentSatiety) {
        this.currentSatiety = currentSatiety;
    }

    public double getCurrentSatiety() {
        return currentSatiety;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Animal(OrganismConfig config) {
        this.config = config;
        this.currentSatiety = config.getFoodNeeded();
    }

    public OrganismConfig getConfig() {
        return config;
    }

    @Override
    public void eat(ConcurrentHashMap<String, List<Organism>> residents) {
        String predatorType = this.getClass().getSimpleName().toUpperCase();
        double foodNeeded = config.getFoodNeeded();

        for (Map.Entry<String, List<Organism>> entry : residents.entrySet()) {
            String preyType = entry.getKey();
            List<Organism> preyList = entry.getValue();

            if (predatorType.equals(preyType) || preyList.isEmpty()) {
                continue;
            }

            int chance = EatingTable.getChance(predatorType, preyType);
            if (chance == 0) {
                continue;
            }
            for (Organism target : preyList) {
                if (currentSatiety >= foodNeeded) {
                    break;
                }

                int random = ThreadLocalRandom.current().nextInt(100);
                if (random < chance) {
                    double foodVal = 0;
                    boolean isEaten = false;

                    if (target instanceof Grass grass) {
                        foodVal = grass.decrease();
                        if (grass.getMass() <= 0) {
                            preyList.remove(target);
                        }
                        isEaten = true;
                    } else {
                        Animal preyAnimal = (Animal) target;
                        if (preyList.remove(target)) {
                          foodVal = preyAnimal.config.getMaxWeight();
                          isEaten = true;
                        }
                    }
                    if (isEaten) {
                        currentSatiety = Math.min(foodNeeded, currentSatiety + foodVal);
                    }

                }
            }

            if (currentSatiety >= foodNeeded) {
                break;
            }

        }
    }
}



