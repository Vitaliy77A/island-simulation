package java_rush_projectt2.island.island_services;

import java_rush_projectt2.island.map.Island;
import java_rush_projectt2.island.map.Location;
import java_rush_projectt2.island.model_organizm.Organism;
import java_rush_projectt2.island.model_organizm.animal.Animal;
import java_rush_projectt2.island.utilits.factory.OrganismFactory;
import java_rush_projectt2.island.utilits.factory.OrganizmConfing;
import java_rush_projectt2.island.utilits.factory.TypeOrganism;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class ReproduceServise  {
    public void timeToReproduce(Island island) {
        Location [][] map = island.getMap();
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        for (int x = 0; x < map.length ; x++) {
            for (int y = 0; y < map[x].length; y++) {

                Location location = map[x][y];

                ConcurrentHashMap<String, List <Organism>> residents = location.getResidents();
                List<Organism> newOrganism = new ArrayList<>();
                for(Map.Entry<String, List<Organism>> entry : residents.entrySet()) {
                    String typyName = entry.getKey();
                    List<Organism> curentAnimal = entry.getValue();
                    if (curentAnimal.isEmpty()) {
                        continue;
                    }

                    OrganizmConfing confing = OrganizmConfing.valueOf(typyName);
                    int curentCount = curentAnimal.size();

                    if (curentCount >= confing.getMaxPopulation()) {
                        continue;
                    }

                    if (typyName.equals("GRASS")) {
                        if (localRandom.nextInt(100) < confing.getReproduceChans()) {
                            newOrganism.add(OrganismFactory.createOrganism(TypeOrganism.GRASS));
                        }
                    } else if (curentAnimal.get(0) instanceof Animal) {

                        if (curentCount >= 2) {
                            if (localRandom.nextInt(100) < confing.getReproduceChans()) {
                                Animal babyAnimal = OrganismFactory.createOrganism(TypeOrganism.valueOf(typyName));
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
