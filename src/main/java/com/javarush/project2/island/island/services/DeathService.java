package com.javarush.project2.island.island.services;

import com.javarush.project2.island.map.Island;
import com.javarush.project2.island.map.Location;
import com.javarush.project2.island.model.organism.animal.Animal;
import com.javarush.project2.island.utilits.factory.OrganismConfig;

import java.util.List;
import java.util.stream.Collectors;

public class DeathService {

    private List<Animal> getAnimalsInLocation(Location location) {
        return location.getResidents().values().stream()
                .flatMap(List::stream)
                .filter(it -> it instanceof Animal)
                .map(it -> (Animal) it)
                .collect(Collectors.toList());
    }

    public void applyStarvationAndAging(Island island) {
        Location[][] map = island.getMap();

        for (Location[] locations : map) {
            for (Location location : locations) {
                List<Animal> actors = getAnimalsInLocation(location);

                for (Animal animal : actors) {
                    OrganismConfig config = animal.getConfig();

                    double newSatiety = animal.getCurrentSatiety() - config.getHungerLossRate();
                    animal.setCurrentSatiety(newSatiety);
                    animal.setAge(animal.getAge() + 1);
                }
            }
        }
    }



    public void checkDeathConditions(Island island) {
        Location[][] map = island.getMap();

        for (Location[] locations : map) {
            for (Location location : locations) {
                List<Animal> actors = getAnimalsInLocation(location);

                for (Animal animal : actors) {
                    OrganismConfig config = animal.getConfig();

                    if (animal.getCurrentSatiety() <= 0 || animal.getAge() >= config.getMaxLifespan()) {

                        location.removeOrganism(animal);
                    }
                }
            }
        }
    }
}
