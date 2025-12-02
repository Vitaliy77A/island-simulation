package java_rush_project2.island.island_services;

import java_rush_project2.island.map.Island;
import java_rush_project2.island.map.Location;
import java_rush_project2.island.model_organism.Organism;
import java_rush_project2.island.utilits.factory.TypeOrganism;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticService {

    public void printStatistic(Island island, int tick) {
        Map<String, Integer> statistic = new HashMap<>();
        Location[][] map = island.getMap();

        for (Location[] locations : map) {
            for (Location location : locations) {

                for (Map.Entry<String, List<Organism>> entry : location.getResidents().entrySet()) {
                    String type = entry.getKey();
                    List<Organism> organismList = entry.getValue();
                    int count = organismList.size();

                    statistic.merge(type, count, Integer::sum);

                }
            }
        }
        System.out.println("Tact: " + tick + " ");
        System.out.println("Total number of locations: " + (island.getWidth() * island.getHeight()));

        statistic.forEach((type, statistics) -> System.out.printf(" %-15s: %d %n", type, statistics));

        System.out.println("_______________________________");
    }

    public int getTotalOrganismsCount(Island island) {
        int countAnimals = 0;
        Location[][] map = island.getMap();

        for (Location[] locations : map) {
            for (Location location : locations) {
                for (Map.Entry<String, List<Organism>> entry : location.getResidents().entrySet()) {
                    String typeName = entry.getKey();

                    TypeOrganism type = TypeOrganism.valueOf(typeName);
                    if (type.getCategory() == TypeOrganism.Category.ANIMAL) {
                        countAnimals += entry.getValue().size();
                    }
                }
            }
        }

        return countAnimals;
    }

    public boolean isIslandEmpty(Island island) {

        return getTotalOrganismsCount(island) <= 0;
    }
}
