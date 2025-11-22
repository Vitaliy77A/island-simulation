package java_rush_projectt2.island.model_organizm.animal;


import java_rush_projectt2.island.model_organizm.*;
import java_rush_projectt2.island.model_organizm.plant.Grass;
import java_rush_projectt2.island.utilits.EatingTabletServise;
import java_rush_projectt2.island.utilits.factory.OrganizmConfing;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal implements Movebel, Eating, Reproduce, Organism {

    protected final OrganizmConfing config;
    protected volatile double currentSatiety;
    public int age = 0;

    public void setCurrentSatiety(double currentSatiety) {
        this.currentSatiety = currentSatiety;
    }

    public double getCurrentSatiety() {
        return currentSatiety;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal(OrganizmConfing config) {
        this.config = config;
        this.currentSatiety = config.getFoodNeeded();
    }

    public OrganizmConfing getConfig() {
        return config;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " в пошуках їжі");
    }



    @Override
    public void eat(ConcurrentHashMap<String, List<Organism>> residents) {
        String predatorType = this.getClass().getSimpleName().toUpperCase();
        double foodNeeded = config.getFoodNeeded();

        for (Map.Entry<String, List<Organism>> entry : residents.entrySet()) {
            String preyType = entry.getKey();
            List<Organism> preyList = entry.getValue();

            int chance = EatingTabletServise.getChans(predatorType, preyType);
            if (chance == 0 || predatorType.equals(preyType) || preyList.isEmpty()) {
                continue;
            }


            var preyIterator = preyList.iterator();
            while (currentSatiety < foodNeeded && preyIterator.hasNext()) {

                Organism target = preyIterator.next();
                int random = ThreadLocalRandom.current().nextInt(100);

                if (random < chance) {
                    double foodValue = 0;

                    if (target instanceof Grass grass) {

                        foodValue = grass.decrease();
                        if (grass.getMass() <= 0) {
                            preyIterator.remove();
                        }
                    } else {

                        Animal preyAnimal = (Animal) target;
                        foodValue = preyAnimal.config.getMaxWeight();
                        preyIterator.remove();
                    }

                    currentSatiety = Math.min(foodNeeded, currentSatiety + foodValue);

                    currentSatiety = Math.min(foodNeeded, currentSatiety + foodValue);
                }

            }

            if (currentSatiety >= foodNeeded) {
                break;
            }
        }
    }


    @Override
    public void reproduce() {
        System.out.println(getClass().getSimpleName() + " розмножується");
    }
}

