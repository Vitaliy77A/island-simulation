package java_rush_project2.island.island_services;

import java_rush_project2.island.map.Island;
import java_rush_project2.island.map.Location;
import java_rush_project2.island.model_organism.Organism;
import java_rush_project2.island.model_organism.animal.Animal;
import java_rush_project2.island.utilits.factory.OrganismFactory;
import java_rush_project2.island.utilits.factory.OrganismConfig;
import java_rush_project2.island.utilits.factory.TypeOrganism;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class ReproduceService {
    public void timeToReproduce(Island island) {
        Location [][] map = island.getMap();
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        for (Location[] locations : map) {
            for (Location location : locations) {

                ConcurrentHashMap<String, List<Organism>> residents = location.getResidents();
                List<Organism> newOrganism = new ArrayList<>();
                for (Map.Entry<String, List<Organism>> entry : residents.entrySet()) {
                    String typeName = entry.getKey();
                    List<Organism> currentAnimal = entry.getValue();
                    if (currentAnimal.isEmpty()) {
                        continue;
                    }

                    OrganismConfig config = OrganismConfig.valueOf(typeName);
                    int currentCount = currentAnimal.size();

                    if (currentCount >= config.getMaxPopulation()) {
                        continue;
                    }

                    if (typeName.equals("GRASS")) {
                        if (localRandom.nextInt(100) < config.getReproduceChance()) {
                            newOrganism.add(OrganismFactory.createOrganism(TypeOrganism.GRASS));
                        }
                    } else if (currentAnimal.get(0) instanceof Animal) {

                        if (currentCount >= 2) {
                            if (localRandom.nextInt(100) < config.getReproduceChance()) {
                                Animal babyAnimal = OrganismFactory.createOrganism(TypeOrganism.valueOf(typeName));
                                newOrganism.add(babyAnimal);
                            }
                        }

                    }

                }

                newOrganism.forEach(location::addOrganism);

            }

        }
    }
}
